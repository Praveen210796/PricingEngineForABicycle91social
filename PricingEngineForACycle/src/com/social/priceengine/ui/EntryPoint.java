package com.social.priceengine.ui;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;

import com.social.priceengine.util.PriceEngineUtil;
import com.social.pricingengine.core.PricingEngine;




public class EntryPoint {
	
	private static JSONArray enquiry = null;

	private static String readInput(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static void main(String[] args) {
		String thisPath = PriceEngineUtil.filePath + "bicycle.json";

		String result = readInput(thisPath);

		try {

			enquiry = new JSONArray(result);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		PricingEngine priceEngine = new PricingEngine(enquiry);
		priceEngine.calculatePrice();

		System.out.println("write to output folder");
	}


}
