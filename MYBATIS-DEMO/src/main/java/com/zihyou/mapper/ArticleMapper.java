package com.zihyou.mapper;

import com.zihyou.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    Article selectArticleById(int id);
    //散装参数形式
    //List<Article> selectArticleByCondition(@Param("status") int status, @Param("title") String title, @Param("flag") String flag);
    //封装对象形式
//    List<Article> selectArticleByCondition(Article article);
    //Map集合
     List<Article> selectArticleByCondition(Map articleMap);

}
