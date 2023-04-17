package com.webstaurant.utils;

public class ReadConfig extends Constants {

	public ReadConfig() {

	}

	private ReadConfig(String filepath) {
		try {
			// to load web elements
			objMap = new ObjectMap(pathOR);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ReadConfig instance;

	public static ReadConfig getInstance() {

		if (instance == null) {
			instance = new ReadConfig("");
		}
		return instance;

	}

}
