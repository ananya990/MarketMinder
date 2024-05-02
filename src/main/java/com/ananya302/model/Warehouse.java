package com.ananya302.model;

public class Warehouse {
    private String ptype;
    private String quantity;
    private String sid;

    public Warehouse(String ptype, String quantity, String sid) {
        this.ptype = ptype;
        this.quantity = quantity;
        this.setSid(sid);
    }

    public Warehouse() {
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
}
