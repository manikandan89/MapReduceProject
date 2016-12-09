package edu.neu.mr.project;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TrainingModelMapper extends Mapper<LongWritable, Text, Text, BirdData> {

	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String line = value.toString();
		if(!line.startsWith("SAMPLING_EVENT_ID")){
			String[] st = line.split(",");
			
			// emit year (at index 4) as Key, BirData Object as value
			context.write(new Text(st[4]), new BirdData(st));				
		}
	}	
	
}
