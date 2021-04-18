package com.knight.springboot.lucene.service;


import com.knight.springboot.entity.ExpressMessage;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LuceneService {

    private final ExpressService expressService;

    public void createIndex() throws IOException {
        // 1: 采集数据
        List<ExpressMessage> express = expressService.findList();

        // 2: 创建文档对象
        List<Document> doc = new LinkedList<>();
        for (ExpressMessage exp : express) {
            Document document = new Document();

            document.add(new StringField("id", String.valueOf(exp.getId()), Field.Store.YES));
            document.add(new TextField("note", exp.getNote(), Field.Store.YES));
            document.add(new StringField("consignee", exp.getConsignee(), Field.Store.YES));
            if (Objects.isNull(exp.getCourier_number())) {
                exp.setCourier_number("-1");
            }
            document.add(new StringField("number", exp.getCourier_number(), Field.Store.YES));
            doc.add(document);
        }

        // 3: 创建分词器, 标准分词器，对英文分词效果较好，对中文是单字分词。
        Analyzer analyzer = new StandardAnalyzer();

        // 4: 创建 directory 目录对象，保存索引库
        Directory dir = FSDirectory.open(Paths.get("E:\\LuceneIndex"));

        // 5: 创建 IndexWriterConfig 对象，这个对象中指定切分词使用的分词器
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        // 6: 创建 IndexWriter 输出流对象，指定输出的位置和使用的 config 初始化对象
        IndexWriter writer = new IndexWriter(dir, config);

        // 7: 写入文档到索引库
//        writer.addDocuments(doc);

        for (Document d : doc) {
            writer.addDocument(d);
        }

        // 8: 释放资源
        writer.close();
        dir.close();
    }

    public void search(String keyword) throws ParseException, IOException {
        // 1: 创建分词器，对查询关键字进行分词；并且必须和创建索引时使用的分词器一样，否则分词效果不一样，可能导致搜索结果不符合预期
        Analyzer analyzer = new StandardAnalyzer();

        // 创建查询对象
        // 默认查询域
        // 分词器
        QueryParser queryParser = new QueryParser("note", analyzer);

        // 设置搜索关键词
        Query query =  queryParser.parse(keyword);

        // 指定 索引位置
        Directory dir = FSDirectory.open(Paths.get("E:\\LuceneIndex"));

        // 创建输入流对象
        IndexReader indexReader =  DirectoryReader.open(dir);
        // 创建搜索对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 搜索并返回结果 第二个参数： 返回多少条数据，分页使用；
        TopDocs topDocs = indexSearcher.search(query, 20);

        // 获取结果集的总数
        System.out.println(topDocs.totalHits);

        // 获取结果集
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        if (Objects.nonNull(scoreDocs)) {
            for (ScoreDoc doc : scoreDocs) {
                // lucene 为 每个document 分配的唯一id
                int id = doc.doc;
                // 通过文档id 读取文档
                Document each = indexSearcher.doc(id);
                System.out.println(each.get("id") + " -- " +each.get("note") + " -- " + each.get("number"));
            }
        }

        indexReader.close();
        dir.close();
    }

    /**
     * 更新索引
     * @param id 业务id
     */
    public void updateIndex(Integer id) throws IOException{
        Document document = new Document();

        document.add(new StringField("id", "36903", Field.Store.YES));
        document.add(new TextField("note", "0108（9日德邦到付）篮克 广西高巍 广西幼师 109 桔红 26套", Field.Store.YES));
        document.add(new StringField("consignee", "", Field.Store.YES));
        document.add(new StringField("number", "1241241", Field.Store.YES));


        // 3: 创建分词器, 标准分词器，对英文分词效果较好，对中文是单字分词。
        Analyzer analyzer = new StandardAnalyzer();

        // 4: 创建 directory 目录对象，保存索引库
        Directory dir = FSDirectory.open(Paths.get("E:\\LuceneIndex"));

        // 5: 创建 IndexWriterConfig 对象，这个对象中指定切分词使用的分词器
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        // 6: 创建 IndexWriter 输出流对象，指定输出的位置和使用的 config 初始化对象
        IndexWriter writer = new IndexWriter(dir, config);

        // term 是个词对象，是修改的条件，这里意为 修改 id = 36903 的 域对应的文档
        writer.updateDocument(new Term("id", "36903"), document);


        writer.close();
        dir.close();
    }


    public void deleteDocument() throws IOException{
        // 3: 创建分词器, 标准分词器，对英文分词效果较好，对中文是单字分词。
        Analyzer analyzer = new StandardAnalyzer();

        // 4: 创建 directory 目录对象，保存索引库
        Directory dir = FSDirectory.open(Paths.get("E:\\LuceneIndex"));

        // 5: 创建 IndexWriterConfig 对象，这个对象中指定切分词使用的分词器
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        // 6: 创建 IndexWriter 输出流对象，指定输出的位置和使用的 config 初始化对象
        IndexWriter writer = new IndexWriter(dir, config);

        writer.deleteDocuments(new Term("id", "36903"));


        writer.deleteAll();

        writer.close();
        dir.close();

    }

    public void testAnalyzer() {
        Analyzer ikAnalyzer = new IKAnalyzer();
    }

}
