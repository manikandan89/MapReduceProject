package edu.neu.mr.project;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TrainingModelReducer extends Reducer<Text, BirdData, Text, IntWritable> {

}
