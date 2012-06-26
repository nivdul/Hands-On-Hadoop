package com.soat.hadoopworkshop;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.soat.hadoopworkshop.ex1.WordCount;
import com.soat.hadoopworkshop.ex2.Anagram;
import com.soat.hadoopworkshop.ex3.MostFrequent;

public class HadoopWorkshop {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		if (args.length != 3) {
			printUsageAndExit();
		}
		
		HadoopWorkshopConfig config = null;
		if ("ex1".equals(args[0])) {
			config = new WordCount();
		} else if ("ex2".equals(args[0])) {
			config = new Anagram();
		} else if ("ex3".equals(args[0])) {
			config = new MostFrequent();
		} else {
			printUsageAndExit();
		}
		
		// Create a job and configure its input/output path with user provided parameters
		Job job = new Job();
		config.configure(job);
		job.setJarByClass(HadoopWorkshop.class);
		FileInputFormat.addInputPath(job, new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		// Submit the job to Hadoop and wait for it to finish
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
	
	public static void printUsageAndExit() {
		System.err.println("Usage: <ex1|ex2|ex3> <input path> <output path>");
		System.exit(-1);
	}
}
