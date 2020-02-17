package com.etass.db;

class Encryption
/***************/
{
    public Encryption(byte[] fileBytes,String key)
    {
	this.fileBytes = fileBytes;
	this.key = key;
	
	// Stick the key in to a character array
	// This is so the file bytes can be offset with
	// the characters as defined by the overall algortihm
	// when either encrypting or decrypting
	// --------------------------------------------------
	
	keys = new char[key.length()];
	pivot = (int)(fileBytes.length/2);
	
	// These long values are just random bits of data junk
	// that are added during the enctypion process
	// to add to the overall scrambling capability
	// 
	// -------------------------------------------------------------
	
	
	delta = 0x9e3779b9;
	alpha = 0x7f2637c6;
	beta  = 0x5d656dc8;
	gamma = 0x653654d9;
	
	// Shift the bits slightly (>> and << bitwise operators)
	// as determined by characters in the key
		// -----------------------------------------------------	

	sumA = (long)(alpha >> key.charAt(0));
	sumB = (long)(beta << key.charAt(1));
	sumC = (long)(gamma >> key.charAt(2));
	sumD = (long)(delta >> key.charAt(3));	
	
	// Sorts out the problem of having an odd or even number of bits

	// ----------------------------------------------------------------
	
	if (fileBytes.length%5 > 0)
	    {
		inter = (int)((fileBytes.length-1)/5);
	    }
	else inter = (int)(fileBytes.length/5);
	
	// forLevel2 is used in the level2 method 
	// --------------------------------------
	
	forLevel2 = key.length();
    }
    
    /**********************************/
    /*    s o m e      m e t h o d s  */
    /**********************************/
    
    public void setFileBytes(byte[] newBytes)
    {
	fileBytes = newBytes;
    }
    
    public byte[] getFileBytes()
    {
	return fileBytes;
    }
    
    
    /*************************************/
    /* D o e s   e x a c t l y   w h a t */
    /* i t   s a y s                     */
    /*************************************/
    
    public void encrypt()
    {
	
	int f = 0;
	boolean truth = true;
	
	
	// Takes user key and makes a biger one
	// for added security
	// ------------------------------------
	
	key = keyStream(); 
	
	
	// probably don't need this bit as it is already defined in
	// the constructor, but I thought I'd leave it in just in case
	// ----------------------------------------------------------- 
	
	keys = new char[key.length()];
	
	for(int c = 0;c<key.length();c++)
	    {
		keys[c] = key.charAt(c);
	    }
	
	
	System.out.println("\nEncrypting\n");
	
	// the outer for loop ensure that the algorithm
	// loops round a lot of time, so that
	// the file is encrypted mutliple times
	// --------------------------------------------
	
	for(int extra = 0;extra<127;extra++)
	    {
		for(int i = 0;i<fileBytes.length;i = i + keys.length)
		    {
			if (truth == false)
			    break;
			f = 0;
			for(int j = i;j<i+keys.length;j++)
			    {
				
				if(j>=fileBytes.length)
				    {
					truth = false;
					break;
				    }
				
				fileBytes[j] = (byte)((fileBytes[j] ^
						       (keys[f] - 'A' << sumD)) ^ (keys[f] + sumD));
				
				sumD -= delta;
				f++;
							    }
			
					    }
		
		fileBytes = splitNSwap(fileBytes);
		
		setFileBytes(fileBytes);
		
	    }
	
	setFileBytes(level2(fileBytes,true));
	
    }
    
    
    public void decrypt()
    {
	
	setFileBytes(level2(fileBytes,false));
	int f = 0;
	boolean truth = true;
	
	key = keyStream();
	
	keys = new char[key.length()];
	
	for(int c = 0;c<key.length();c++)
	    {
		keys[c] = key.charAt(c);
	    }
	
	
	System.out.println("\nDecrypting\n");
	
	for(int extra = 0;extra<127;extra++)
	    {
		fileBytes = getFileBytes();
		
		fileBytes = splitNSwap(fileBytes);
		
  		for(int i = 0;i<fileBytes.length;i = i + keys.length)
		    {
			
			if (truth == false)
			    break;
			
			f = 0;
			for(int j = i;j<i+keys.length;j++)
			    {
				
				if(j>=fileBytes.length)
				    {
					truth = false;
					break;
				    }
				
				fileBytes[j] = (byte)((fileBytes[j] ^
						       (keys[f] - 'A' << sumD)) ^ (keys[f] + sumD));
				
				sumD -= delta;
				f++;				
			    }			
		    }
		setFileBytes(fileBytes);		
	    }			
    }
    

    // To add to the confusion, this method basically
    // takes the byte[] array as encrypted so far
    // splits it in half and then swaps two halves around
    // i.e. a b c d e f would become d e f a b c
    // --------------------------------------------------
    
    public byte[] splitNSwap(byte[] zeBytes)
    {
	if(zeBytes.length%2==0)
	    {
		pivot = (int)(zeBytes.length/2);
	    }
	else pivot = (int)((zeBytes.length-1)/2);
	fileBytez = new byte[zeBytes.length];
	for(int reverse = 0;reverse<pivot;reverse++)
	    {
		fileBytez[reverse] = (byte)(zeBytes[reverse+pivot]^fileBytez[reverse]);
	    }
	
	for (int reverseB = pivot;reverseB<zeBytes.length;reverseB++)
	    {
		fileBytez[reverseB] = (byte)(zeBytes[reverseB - pivot]^fileBytez[reverseB]);
	    }
	setFileBytes(fileBytez);
	return fileBytez;
	
    }
    
    // Problem:
    // So far, if a long key is used and only some of the key is correct
    // then first part of cipher text will still be decrypted
    // so:
    // (if you want to see the key that it produces uncomment print statement)
    // -----------------------------------------------------------------------
    
    public String scrambleKey(String toBeScrambledFurther)
    {
	pivot = (int)(toBeScrambledFurther.length()/2);
	String newKey = "";
	String sub1 = "", sub2 = "";
	
	for (int a = 0; a<pivot;a++)
	    {
		sub1 += toBeScrambledFurther.charAt(a+pivot);
	    }
	
	for (int b = pivot; b<toBeScrambledFurther.length();b++)
	    {
		sub2 += toBeScrambledFurther.charAt(b-pivot);
	    }
	
	newKey = sub1+sub2;

	//System.out.println(newkey);
	
	return newKey;
    }
    
    
    /*
     * shuffles around the fileBytes in blocks of key.length().
     * at present this algorithm still needs some heavy debugging
     * It is not presently powerful enough for commercial - class
     * encryption. It needs to be fixed....
     * The problem lies with the fact, that some times, when a short text-file
     * is encrypted, some of the 'central' text is still partially scrambled
     */
    
    
    // What is this function passed ?
    // Answer - basically two parameters - the first is
    // an array of bytes that need to be scrambled. The second
    // is a boolean - true if the array is being scrambled
    // and false if being descrambled etc.....
    // -------------------------------------------------------
    
    
    
    public byte[] level2(byte[] oldBytes, boolean state)
    {
	
	if(state)
	    System.out.println("Scrambling encrypted data");
	else System.out.println("\nDescrambling encrypted data");
     
	int s = forLevel2;

	int stop = oldBytes.length%s;

	// some of these variables and loops are currently obsolete

	byte[] newBytes = new byte[oldBytes.length];
	byte[] tempBytes = new byte[oldBytes.length-stop];
	byte[] resultBytes = new byte[oldBytes.length];
	byte[] remainderBytes = new byte[stop];

	int hello = oldBytes.length-stop;

	// obsolete loops

	for (int old = 0;old<oldBytes.length-stop;old++)
	    {
		tempBytes[old] = oldBytes[old];
	    }

	for (int old = 0;old<stop;old++)
	    {
		remainderBytes[old] = oldBytes[(oldBytes.length-stop+old)];
	    }


	
	if (state)
	    {
		for (int outer = 0;outer<s;outer++)
		    {
			for (int c = outer;c<hello+outer;c+=s)
			    {
				if(c+s<oldBytes.length)
				 {
					newBytes[c] = (byte)(oldBytes[c+s]-sumA);
					newBytes[c+s] = (byte)(oldBytes[c]+sumB);
					    }
					else break;
				
			    }
		    }
	    }	
	else if (!state)
	    {
		for (int outer = s-1;outer >=0;outer--)
		    {
			for(int c = (hello-1-outer);c>=0-outer;c-=s)
			    {
				if(c-s>=0)
				  {
					newBytes[c-s] = (byte)(oldBytes[c]-sumB);
					newBytes[c] = (byte)(oldBytes[c-s]+sumA);
				
					  }
					else break;
			    }
			if (outer <= 0)break;else continue;
		    }
		
		
	    }
	    

	// obsolete code
	// experimental

	for(int rep = 0;rep<newBytes.length;rep++)
	    {
		resultBytes[rep]=newBytes[rep];
	    }

	for(int rep = 0;rep<remainderBytes.length;rep++)
	    {
		resultBytes[rep]=remainderBytes[rep];
	    }
	setFileBytes(newBytes);
	return newBytes;
    }
    
    
    /* The keyStream() method takes the user key
     * and enlarges it to (key.length()*key.length()+
     * key.length())*128, in the following algorithmic method.
     * This improves security. I.e. longer keys are
     * much harder to crack
     */
    
    public String keyStream()
    {
	
	System.out.println("\nGenerating key stream\n");
	
	
	String answer = key;
	String thekey = key;
	
	for(int i = 0;i<(thekey.length()*128);i++)
	    {
		answer = answer + getPart(thekey);
		thekey = getPart(thekey);
	    }
	//answer = scrambleKey(answer);
	return answer;
	}
    
    // KeyStream helper method
    // -----------------------
    
    public String getPart(String thekey)
    {
	char[] keyPart = new char[thekey.length()];
	String result = "";
	
	for(int c = 0;c<thekey.length()-1;c++)
	    {
		keyPart[c] = (char)(thekey.charAt(c+1) - 1);
	    }
	
	keyPart[thekey.length()-1] = thekey.charAt(0);
	for(int put = 0;put<keyPart.length;put++)
	    {
		result = result + keyPart[put];
	    }
	
	return result;
    }
    

    private String key;
    private char[] keys;
    private byte[] fileBytes;
    private byte[] fileBytez;
    private int pivot;
    private int inter;
    private long alpha;
    private long beta;
    private long gamma;
    private long delta;
    private long sumA;
    private long sumB;
    private long sumC;
    private long sumD;
    private byte[] fileBytesB;
    private int forLevel2;
	}
