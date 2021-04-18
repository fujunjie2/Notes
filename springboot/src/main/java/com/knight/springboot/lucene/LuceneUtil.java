package com.knight.springboot.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;

public class LuceneUtil {


    private static Directory directory;
    private static Analyzer analyzer;


    static {
        try {
            directory = FSDirectory.open(Paths.get("E://LuceneIndex"));
            analyzer = new IKAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
