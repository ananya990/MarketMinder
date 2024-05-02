package com.ananya302.model;

import java.util.Date;

public class Promotion {
    private String promoCode;
    private String promoName;
    private Date startDate;
    private Date endDate;
    private double discountPercentage;

    public Promotion(String promoCode, String promoName, 
    		         Date startDate, Date endDate, double discountPercentage) {
        this.promoCode = promoCode;
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }

    public Promotion() {
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
}