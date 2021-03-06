package com.rueggerllc.hadoop.tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.hadoop.utils.WeatherDataReader;

public class WeatherTests {

	private static Logger logger = Logger.getLogger(WeatherTests.class);
	
	@BeforeClass
	public static void setupClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setupTest() throws Exception {
	}

	@After
	public void tearDownTest() throws Exception {
	}
	
	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Dummy Test");
	}
	
	@Test
	public void testReadWeatherData() {
		WeatherDataReader weatherDataReader = new WeatherDataReader();
		weatherDataReader.execute("/1901.txt");
		weatherDataReader.execute("/1902.txt");
	}
	

	
}
