package com.rueggerllc.hadoop.weather;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// Input Key
// Input Value
// Output Key
// Output Value
public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		

	// Input Key
	// Input Values
	@Override
	public void reduce(Text mapKeyYear, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		// Get Max Value
		int maxValue = Integer.MIN_VALUE;
		for (IntWritable value : values) {
			maxValue = Math.max(maxValue, value.get());
		}
		
		// Write Max Value
		context.write(mapKeyYear, new IntWritable(maxValue));
		
	}
	

}
