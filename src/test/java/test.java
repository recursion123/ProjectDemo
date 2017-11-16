import com.recursion123.BaseApplication;
import com.recursion123.blog.dao.ArticleDao;
import com.recursion123.blog.model.Article;
import com.recursion123.blog.model.ArticleTag;
import com.recursion123.blog.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseApplication.class})
public class test {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testQuery() throws UnsupportedEncodingException {
        ArticleTag articleTag=new ArticleTag();
        articleTag.setName("hahaha111");
        articleTag.setType("success");
        System.out.println(articleDao.insertArticleTag(articleTag));
    }
}