package com.rueggerllc.hadoop.weather;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Input Key
// Input Value
// Output Key
// Output Value
public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private static final int MISSING = 9999;
	

	// Input Key
	// Input Value
	@Override
	public void map(LongWritable inputKey, Text inputValue, Context context) throws IOException, InterruptedException {
		
		String line = inputValue.toString();
		String year = line.substring(15, 19);
		int airTemperature = 0;
		
		if (line.charAt(87) == '+') {
			airTemperature = Integer.parseInt(line.substring(88,92));
		} else {
			airTemperature = Integer.parseInt(line.substring(87,92));
		}
		
		String quality = line.substring(92,93);
		if (airTemperature != MISSING && quality.matches("[01459]")) {
			// Output Key, Output Value
			context.write(new Text(year), new IntWritable(airTemperature));
		}
		
	}
	

}
