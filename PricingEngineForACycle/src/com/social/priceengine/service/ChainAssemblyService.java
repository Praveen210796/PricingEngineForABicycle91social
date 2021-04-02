package com.social.priceengine.service;

import com.social.priceengine.dao.ChainAssemblyDAO;
import com.social.priceengine.model.ChainAssembly;

public class ChainAssemblyService {
	
	private Long date = null;

	private ChainAssembly chainAssembly = null;

	private ChainAssemblyDAO chainAssemblyDAO = null;

	public ChainAssemblyService(Long date, ChainAssembly chainAssembly) {
		this.date = date;
		this.chainAssembly = chainAssembly;
		chainAssemblyDAO = new ChainAssemblyDAO();
	}

	public double getPrice() {
		return chainAssembly.getPrice();
	}

	public void calculatePrice() {
		double sizePrice = chainAssemblyDAO.getChainSizePrice(chainAssembly.getChainSize(), date);

		double speedPrice = chainAssemblyDAO.getChainSpeedPrice(chainAssembly.getSpeed(), date);

		double totalPrice = sizePrice + speedPrice;
		chainAssembly.setPrice(totalPrice);
	}

}
