package com.social.pricingengine.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import com.social.priceengine.model.Bicycle;
import com.social.priceengine.service.ChainAssemblyService;
import com.social.priceengine.service.FrameService;
import com.social.priceengine.service.HandleService;
import com.social.priceengine.service.SeatService;
import com.social.priceengine.service.WheelService;



public class PriceCalculator implements Callable<Bicycle> {

	Bicycle bicycle;

	public PriceCalculator(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	
	@Override
	public Bicycle call() throws Exception {

		String date = bicycle.getDate();
		Long epochDate = getEpochTime(date);

		WheelService wheelService = new WheelService(epochDate, bicycle.getWheel());
		wheelService.calculatePrice();

		FrameService frameService = new FrameService(epochDate, bicycle.getFrame());
		frameService.calculatePrice();

		HandleService handleService = new HandleService(epochDate, bicycle.getHandle());
		handleService.calculatePrice();

		ChainAssemblyService chainAssemblyService = new ChainAssemblyService(epochDate, bicycle.getChainAssembly());
		chainAssemblyService.calculatePrice();

		SeatService seatService = new SeatService(epochDate, bicycle.getSeat());
		seatService.calculatePrice();

		bicycle.calculatePrice();
		
		return bicycle;
	}

	private Long getEpochTime(String dateInString) {
		Long epochTime = Long.valueOf(0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date inputDate = formatter.parse(dateInString);
			epochTime = inputDate.getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return epochTime;
	}
}
