package com.ananya302.model;

public class Customer {
    private int cid;
    
    private String cname;
    
    private String caddress;
    
    private String cphoneNumber;
    
    private int purchaseID;

    public Customer(int cid, String cname, String caddress, String cphoneNumber, int purchaseID) {
        this.cid = cid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphoneNumber = cphoneNumber;
        this.purchaseID = purchaseID;
    }

    public Customer() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphoneNumber() {
        return cphoneNumber;
    }

    public void setCphoneNumber(String cphoneNumber) {
        this.cphoneNumber = cphoneNumber;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }
}

