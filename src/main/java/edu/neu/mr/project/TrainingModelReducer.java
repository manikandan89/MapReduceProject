package edu.neu.mr.project;

import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import weka.core.Attribute;
import weka.core.Instances;


public class TrainingModelReducer extends Reducer<Text, BirdData, Text, IntWritable> {

	private Instances createTrainingSet(ArrayList<Attribute> wekaAttributes) {
		Instances test = new Instances("TEST", wekaAttributes, 0);
		test.setClassIndex(-1);
		return test;
	}
	
	
	
}
