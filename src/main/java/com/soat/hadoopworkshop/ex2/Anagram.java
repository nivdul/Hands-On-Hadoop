package com.soat.hadoopworkshop.ex2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

import com.soat.hadoopworkshop.HadoopWorkshopConfig;

public class Anagram implements HadoopWorkshopConfig {

	/*
	 * Exercice 2:
	 * 
	 * Ecrire la classe AnagramMapper et AnagramReducer pour regrouper les anagrames
	 * dans un fichier d'entree contenant un mot par ligne.
	 * Utiliser le fichier anagrams.txt, present a la racine du projet pour tester.
	 */
	
	@Override
	public void configure(Job job) {
		job.setJarByClass(Anagram.class);
		
		job.setJobName("Hadoop Workshop Anagram");

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setMapperClass(AnagramMapper.class);
		job.setReducerClass(AnagramReducer.class);
	}
}
