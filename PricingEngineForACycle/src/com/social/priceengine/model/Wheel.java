package com.social.priceengine.model;

public class Wheel {
	
	private String spoke;

	private String rim;

	private String tube;

	private String tyre;
	
	private Double price;
	

	public Wheel() {
		super();
	}

	public Wheel(String spoke, String rim, String tube, String tyre, Double price) {
		super();
		this.spoke = spoke;
		this.rim = rim;
		this.tube = tube;
		this.tyre = tyre;
		this.price = price;
	}

	public String getSpoke() {
		return spoke;
	}

	public void setSpoke(String spoke) {
		this.spoke = spoke;
	}

	public String getRim() {
		return rim;
	}

	public void setRim(String rim) {
		this.rim = rim;
	}

	public String getTube() {
		return tube;
	}

	public void setTube(String tube) {
		this.tube = tube;
	}

	public String getTyre() {
		return tyre;
	}

	public void setTyre(String tyre) {
		this.tyre = tyre;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
