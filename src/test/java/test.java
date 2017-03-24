import com.recursion123.application.BaseApplication;
import com.recursion123.dao.UserDaoSqlImpl;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import com.recursion123.model.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseApplication.class})
@ComponentScan("com.recursion123")
public class test {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserDaoSqlImpl userDaoSql;

    @Test
    public void testQuery(){
        System.out.println(userDaoSql.listUser(new User("zhang","123",Role.USER)));
    }
}