package com.knight.springboot.lucene.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * lucene 高级搜索
 */

@Service
public class LuceneSearchService {

    // 文本搜索
    public void textSearch()   {

        Analyzer analyzer = new IKAnalyzer();

        QueryParser parser = new QueryParser("note", analyzer);

    }

    // 数值范围查询
    public void rangeSearch () {

        // 整数类型的范围查询
        Query rangeQuery = IntPoint.newRangeQuery("price", 10, 20);
        // 整数类型的 确切值查询
        Query exactQuery = IntPoint.newExactQuery("price", 30);
        // 整数类型的 列表查询， 参数可以是 Collection , 数组
        Query query = IntPoint.newSetQuery("price", 20, 21, 22);

    }

    // 组合查询
    public void combineSearch() throws Exception{
        Analyzer analyzer = new IKAnalyzer();
        QueryParser queryParser = new QueryParser("note", analyzer);
        Query noteQuery = queryParser.parse("广西高峰");

        Query rangeQuery = IntPoint.newRangeQuery("price", 10, 200);


        /**
         *  BooleanClause.Occur.MUST 相当于 and
         *  BooleanClause.Occur.MUST_NOT  相当于  not
         *  BooleanClause.Occur.SHOULD    相当于 or
         *  BooleanClause.Occur.FILTER    不参与打分
         */

        BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
        queryBuilder.add(rangeQuery, BooleanClause.Occur.MUST);
        queryBuilder.add(noteQuery, BooleanClause.Occur.MUST);

    }

}
