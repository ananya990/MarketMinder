package com.ananya302.model;

import java.util.Date;

public class Employee {
	private int eid;
	private String ename;
	private String eemail;
	private String ephoneNumber;
	private String eaddress;
    private Date dob;
    private Date joinDate;
    private Date endDate;
	private double salary;
	
    public Employee(int eid, String ename, String eemail, String ephoneNumber, 
    		        String eaddress, Date dob, Date joinDate, Date endDate, double salary) 
    {
        this.eid = eid;
        this.ename = ename;
        this.eemail = eemail;
        this.ephoneNumber = ephoneNumber;
        this.eaddress = eaddress;
        this.dob = dob;
        this.joinDate = joinDate;
        this.endDate = endDate;
        this.salary = salary;
    }
		
	 public Employee() {
	    }
		
	public int getEid(){
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getEname () {
		return ename;
	}
	
	public void setEname (String ename) {
		this.ename = ename;
	}
	
	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEphoneNumber() {
		return ephoneNumber;
	}

	public void setEphoneNumber(String ephoneNumber) {
		this.ephoneNumber = ephoneNumber;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
