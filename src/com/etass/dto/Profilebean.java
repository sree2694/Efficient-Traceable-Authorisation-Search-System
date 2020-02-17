package com.etass.dto;

import java.io.File;
import java.io.Serializable;



public class Profilebean implements Serializable {

	
	private String loginid;
	private String password;
	private String newpassword;
	private String username;
	private String email;
	private String mobileno;
	private String gender;
	private String address;
	private String role;
	private String status;
	private String file;
	private String filename;
	private int fileid;
	private String ownername;
	private long secretekey;
	private File file1;
	
	
	
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public long getSecretekey() {
		return secretekey;
	}
	public void setSecretekey(long secretekey) {
		this.secretekey = secretekey;
	}
	@Override
	public String toString() {
		return "Profilebean [address=" + address + ", email=" + email
				+ ", file=" + file + ", fileid=" + fileid + ", filename="
				+ filename + ", gender=" + gender + ", loginid=" + loginid
				+ ", mobileno=" + mobileno + ", newpassword=" + newpassword
				+ ", ownername=" + ownername + ", password=" + password
				+ ", role=" + role + ", secretekey=" + secretekey + ", status="
				+ status + ", username=" + username + ", getAddress()="
				+ getAddress() + ", getEmail()=" + getEmail() + ", getFile()="
				+ getFile() + ", getFileid()=" + getFileid()
				+ ", getFilename()=" + getFilename() + ", getGender()="
				+ getGender() + ", getLoginid()=" + getLoginid()
				+ ", getMobileno()=" + getMobileno() + ", getNewpassword()="
				+ getNewpassword() + ", getOwnername()=" + getOwnername()
				+ ", getPassword()=" + getPassword() + ", getRole()="
				+ getRole() + ", getSecretekey()=" + getSecretekey()
				+ ", getStatus()=" + getStatus() + ", getUsername()="
				+ getUsername() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	

}
