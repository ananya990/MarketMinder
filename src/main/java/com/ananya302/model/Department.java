package com.ananya302.model;

public class Department {
    private String deptID;
    private String deptName;
    private String deptManager;
    private int eid;

    public Department(String deptID, String deptName, String deptManager, int eid) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.deptManager = deptManager;
        this.eid = eid;
    }

    public Department() {
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(String deptManager) {
        this.deptManager = deptManager;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}

