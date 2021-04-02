package com.social.priceengine.service;

import com.social.priceengine.dao.WheelDAO;
import com.social.priceengine.model.Wheel;

public class WheelService {
	
	private Long date = null;

	private Wheel wheel = null;

	private WheelDAO wheelDAO = null;

	public WheelService(Long date, Wheel wheel) {
		this.date = date;
		this.wheel = wheel;
		wheelDAO = new WheelDAO();
	}

	public double getPrice() {
		return wheel.getPrice(); 
	}

	public void calculatePrice() {

		double spokePrice = wheelDAO.getSpokePrice(wheel.getSpoke(), date);

		double rimPrice = wheelDAO.getRimPrice(wheel.getRim(), date);

		double tubePrice = wheelDAO.getTubePrice(wheel.getRim(), date);

		double tyrePrice = wheelDAO.getTyrePrice(wheel.getRim(), date);

		double totalPrice = spokePrice + rimPrice + tubePrice + tyrePrice;

		wheel.setPrice(totalPrice);

	}


}
