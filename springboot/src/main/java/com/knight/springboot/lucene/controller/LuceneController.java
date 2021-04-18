package com.knight.springboot.lucene.controller;


import com.knight.springboot.entity.ExpressMessage;
import com.knight.springboot.lucene.service.ExpressService;
import com.knight.springboot.lucene.service.LuceneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/lucene")
@RequiredArgsConstructor
public class LuceneController {


    private final ExpressService expressService;
    private final LuceneService luceneService;

    @GetMapping("/test")
    public ExpressMessage testConnection() {
        return expressService.findById(1);
    }


    @GetMapping("/initIndex")
    public void initIndex() throws IOException {
        luceneService.createIndex();
    }

    @GetMapping("/search")
    public void search(@RequestParam("keyword")String keyword) throws Exception{
        luceneService.search(keyword);
    }

    @GetMapping("/update")
    public void update() throws Exception{
        luceneService.updateIndex(1);
    }

    @DeleteMapping
    public void delete() throws Exception{
        luceneService.deleteDocument();
    }
}
