package com.example.mybatis.generator.demo.controller;

import com.example.mybatis.generator.demo.pojo.Article;
import com.example.mybatis.generator.demo.pojo.ArticleExample;
import com.example.mybatis.generator.demo.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "ArticleController", description = "文章管理接口")
@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    @ApiOperation(value = "获取文章列表")
    public List<Article> articleList(){
        ArticleExample articleExample = new ArticleExample();
        return articleService.selectByExample(articleExample);
    }

    @GetMapping("/list/all")
    @ApiOperation(value = "获取文章列表包含文章内容")
    public List<Article> selectByExampleWithBLOBs(){
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria()
                .andIdIsNotNull()
                .andAuthorIsNotNull();

        return articleService.selectByExampleWithBLOBs(articleExample);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加文章")
    public Integer addArticle(@RequestBody Article article) {

        System.out.println(article.toString());

        return articleService.addArticle(article);
    }


    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取文章")
    public Article getArticle(@RequestParam("id") Integer id) {

        Long start = System.currentTimeMillis();
        Article article = articleService.getArticle(id);
        Long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));

        return article;
    }

    /**
     * 更新一篇文章
     *
     * @param contetnt
     * @param id
     * @return
     */
    @GetMapping("/refresh")
    @ApiOperation(value = "更新文章")
    public Integer update(@RequestParam("content") String contetnt, @RequestParam("id") Integer id) {
        return articleService.updateContentById(contetnt, id);
    }

    /**
     * 删除一篇文章
     *
     * @param id
     * @return
     */
    @GetMapping("/remove")
    @ApiOperation(value = "删除文章")
    public Integer remove(@RequestParam("id") Integer id) {
        return articleService.removeArticleById(id);
    }
}