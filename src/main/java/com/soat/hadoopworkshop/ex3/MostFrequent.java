package com.soat.hadoopworkshop.ex3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

import com.soat.hadoopworkshop.HadoopWorkshopConfig;

public class MostFrequent implements HadoopWorkshopConfig {

	/*
	 * Exercice 3:
	 * 
	 * Ecrire la classe MostFrequentMapper et MostFrequentReducer pour creer un job Hadoop
	 * qui prenne la sortie du job WordCount de l'exercice 1 pour et renvoie le mot le plus
	 * frequent ainsi que son nombre d'occurences dans le texte.
	 */
	
	@Override
	public void configure(Job job) {
		job.setJarByClass(MostFrequent.class);
		
		job.setJobName("Hadoop Workshop MostFrequent");

		job.setMapperClass(MostFrequentMapper.class);
		job.setReducerClass(MostFrequentReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
	}
}
