package com.ananya302.model;

public class Supplier {
    private String sid;
    private String sname;
    private String semail;
    private String saddress;
    private String sphoneNumber;

    public Supplier(String sid, String sname, String semail, String saddress, String sphoneNumber) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.saddress = saddress;
    }

    public Supplier() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSphoneNumber() {
        return sphoneNumber;
    }

    public void setSphoneNumber(String sphoneNumber) {
        this.sphoneNumber = sphoneNumber;
    }
}
