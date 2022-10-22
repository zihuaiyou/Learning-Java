package com.zihyou.test;


import com.zihyou.mapper.ArticleMapper;
import com.zihyou.mapper.StuMapper;
import com.zihyou.pojo.Article;
import com.zihyou.pojo.StuInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {
    int id = 4;
    int status = 1;
    String title = "JavaScript";
    String flag = "%推荐%";
    int[] ids = {14,15,16};

    @Test
    public void testSelectAll() throws IOException {
        //Mapper代理

        //加载核心配置文件获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
        List<StuInfo> stuInfos = stuMapper.selectStuInfo();
        System.out.println(stuInfos);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //Mapper代理

        //加载核心配置文件获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
        Article article = articleMapper.selectArticleById(id);
        System.out.println(article);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //Mapper代理

        //加载核心配置文件获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
//        Article article = articleMapper.selectArticleById(id);
        //散装参数
        // List<Article> articleList  = articleMapper.selectArticleByCondition(status,title,flag);

        //封装对象
//        Article article = new Article();
//        article.setStatus(status);
//        article.setTitle(title);
//        article.setFlag(flag);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);

        //Map集合
        Map articleMap = new HashMap();
//        articleMap.put("status",status);
//        articleMap.put("title",title);
//        articleMap.put("flag",flag);
        List<Article> articleList  = articleMapper.selectArticleByCondition(articleMap);
        System.out.println(articleList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
        Article article = new Article();
        article.setStatus(status);
        article.setTitle(title);
        article.setFlag(flag);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
        int num  = articleMapper.add(article);
//        sqlSession.commit(); //提交事务
        System.out.println(num);
        var id= article.getId();
        System.out.println(id);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
        Article article = new Article();
        article.setStatus(status);
        article.setTitle(title);
        article.setFlag(flag);
        article.setId(id);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
        int num  = articleMapper.update(article);
//        sqlSession.commit(); //提交事务
        System.out.println(num);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDynamicUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
        Article article = new Article();
//        article.setStatus(status);
        article.setTitle(title);
//        article.setFlag(flag);
        article.setId(id);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
        int num  = articleMapper.updateDynamic(article);
//        sqlSession.commit(); //提交事务
        System.out.println(num);
        //释放资源
        sqlSession.close();
    }


    @Test
    public void testDelete() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
        Article article = new Article();
//        article.setStatus(status);
//        article.setTitle(title);
//        article.setFlag(flag);
        article.setId(id);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
            articleMapper.Delete(id);
//        sqlSession.commit(); //提交事务
//        System.out.println(num);
        //释放资源
        sqlSession.close();
    }


    @Test
    public void testDeleteIds() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
        Article article = new Article();
//        article.setStatus(status);
//        article.setTitle(title);
//        article.setFlag(flag);
        article.setId(id);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
        articleMapper.Deletes(ids);
//        sqlSession.commit(); //提交事务
//        System.out.println(num);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void updates() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //true表示autocommit自动提交

        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //封装对象
//        Article article = new Article();
//        article.setStatus(status);
//        article.setTitle(title);
//        article.setFlag(flag);
//        article.setId(id);
//        List<Article> articleList  = articleMapper.selectArticleByCondition(article);
//        System.out.println(articleList);
        int num  = articleMapper.updates(status,flag,id);
//        sqlSession.commit(); //提交事务
        System.out.println(num);
        //释放资源
        sqlSession.close();
    }
}

