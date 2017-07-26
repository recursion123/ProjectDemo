import com.recursion123.BaseApplication;
import com.recursion123.dao.UserDao;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseApplication.class})
public class test {

    @Autowired
    private UserDao userDaoSql;

    @Test
    public void testQuery() {
        System.out.println(userDaoSql.listUser(null));

    }
}