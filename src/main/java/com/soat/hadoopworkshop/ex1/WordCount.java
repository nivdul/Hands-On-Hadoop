package com.soat.hadoopworkshop.ex1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

import com.soat.hadoopworkshop.HadoopWorkshopConfig;

public class WordCount implements HadoopWorkshopConfig {

	/*
	 * Exercice 1:
	 * 
	 * Ecrire la classe WordCountMapper et WordCountReducer pour compter le nombre
	 * d'occurences de chaque mots dans un texte fourni en entree.
	 * Utiliser le fichier rousseau.txt, present a la racine du projet pour tester.
	 */
	
	@Override
	public void configure(Job job) {
		job.setJobName("Hadoop Workshop Word Count");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
	}

}
