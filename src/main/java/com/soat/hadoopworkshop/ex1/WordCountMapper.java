package com.soat.hadoopworkshop.ex1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		// Utiliser context.write(text, int) pour ecrire la sortie du mapper.
	}

}
