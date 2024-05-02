package com.ananya302.model;

public class Product {
    private String pid;
    private String pname;
    private String ptype;
    private Double prize;

    public Product(String pid, String pname, String ptype, Double prize) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.prize = prize;
    }

    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
