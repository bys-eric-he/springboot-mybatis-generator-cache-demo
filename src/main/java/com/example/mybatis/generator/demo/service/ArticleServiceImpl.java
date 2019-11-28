package com.example.mybatis.generator.demo.service;

import com.example.mybatis.generator.demo.dao.ArticleMapper;
import com.example.mybatis.generator.demo.pojo.Article;
import com.example.mybatis.generator.demo.pojo.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@CacheConfig(cacheNames = "articleCache")
public class ArticleServiceImpl implements ArticleService {
    private AtomicInteger count = new AtomicInteger(0);

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取文章列表
     * @param example
     * @return
     */
    public List<Article> selectByExample(ArticleExample example){
        return articleMapper.selectByExample(example);
    }

    /**
     * 获取文章列表,包含文章内容
     * @param example
     * @return
     */
    public List<Article> selectByExampleWithBLOBs(ArticleExample example){
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 增加一篇文章 每次就进行缓存
     *
     * @return
     */
    @CachePut
    public Integer addArticle(Article article) {
        Integer result = articleMapper.insert(article);
        if (result > 0) System.out.println("--执行增加操作--:" + result);
        return result;
    }

    /**
     * 获取文章  以传入的id为键，当state为0的时候不进行缓存
     *
     * @param id 文章id
     * @return
     */
    @Cacheable(key = "#id", unless = "#result==null || #result.state==0")
    public Article getArticle(Integer id) {
        try {
            //模拟耗时操作
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final Article artcile = articleMapper.selectByPrimaryKey(id);
        System.out.println("--执行数据库查询操作" + count.incrementAndGet() + "次" + "id:" + id);
        return artcile;
    }

    /**
     * 通过id更新内容 清除以id作为键的缓存
     *
     * @param id
     * @return
     */
    @CacheEvict(key = "#id")
    public Integer updateContentById(String content, Integer id) {
        int result = -1;
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article != null) {
            article.setContent(content);
            result = articleMapper.updateByPrimaryKeySelective(article);
        }
        System.out.println("--执行更新操作id:--" + id);
        return result;
    }

    /**
     * 通过id移除文章
     *
     * @param id 清除以id作为键的缓存
     * @return
     */
    @CacheEvict(key = "#id")
    public Integer removeArticleById(Integer id) {
        final Integer result = articleMapper.deleteByPrimaryKey(id);
        System.out.println("执行删除操作,id:" + id);
        return result;
    }
}
