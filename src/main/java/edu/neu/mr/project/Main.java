package edu.neu.mr.project;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import mr.hw3_PageRank.PageRank.PageRankReducer;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		System.setProperty("hadoop.home.dir", "/");
		Configuration conf = new Configuration();
		conf.set("mapred.textoutputformat.separator", ":");
		
		Path pathIn = new Path("labeled.csv.bz2");
		Path pathOut = new Path("out");
		
		Job training = Job.getInstance(conf, "training model");
		training.setJarByClass(Main.class);
		training.setMapperClass(TrainingModelMapper.class);
		training.setMapOutputKeyClass(Text.class);
		training.setMapOutputValueClass(BirdData.class);
		
		training.setReducerClass(PageRankReducer.class);
		training.setOutputKeyClass(Text.class);
		training.setOutputValueClass(Text.class);
		
		
		FileInputFormat.addInputPath(getKeys, pathIn);
		Path outputPath = new Path(pathOut + "KeyIndex");
		FileOutputFormat.setOutputPath(getKeys, outputPath);
		outputPath.getFileSystem(conf).delete(outputPath, true);
		getKeys.waitForCompletion(true);

	}

}
