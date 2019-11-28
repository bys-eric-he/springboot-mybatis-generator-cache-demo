package com.example.mybatis.generator.demo.service;

import com.example.mybatis.generator.demo.pojo.Article;
import com.example.mybatis.generator.demo.pojo.ArticleExample;

import java.util.List;

public interface ArticleService {
    Integer addArticle(Article article);
    Article getArticle(Integer id);
    Integer updateContentById(String contetnt, Integer id);
    Integer removeArticleById(Integer id);
    List<Article> selectByExample(ArticleExample example);
    List<Article> selectByExampleWithBLOBs(ArticleExample example);
}
