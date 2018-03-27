package com.rueggerllc.hadoop.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class WeatherDataReader {
	
	private static Logger logger = Logger.getLogger(WeatherDataReader.class);
	private static int MISSING = 9999;
	
	public void execute (String dataFileName) {
		InputStream is = null;
		BufferedReader reader = null;
		try {
			int max = Integer.MIN_VALUE;
			is = WeatherDataReader.class.getResourceAsStream(dataFileName);
			reader = new BufferedReader(new InputStreamReader(is));
			String line = reader.readLine();
			while (line != null) {
				String year = line.substring(15, 19);
				int temperature = 0;
				if (line.charAt(87) == '+') {
					temperature = Integer.parseInt(line.substring(88, 92));
				} else {
					temperature = Integer.parseInt(line.substring(87, 92));
				}
				
				String quality = line.substring(92, 93);
				if (temperature != MISSING && quality.matches("[01459]")) {
					max = Math.max(temperature, max);
					logger.info(year + " " + temperature + " " + quality);
				}
				
				line = reader.readLine();
			}
			logger.info("Max=" + max);
			
		} catch (Exception e) {
			
		} finally {
			
		}
	}
	
	private void close(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (Exception e) {
		}
	}
	private void close(BufferedReader reader) {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (Exception e) {
		}
	}
	

}
