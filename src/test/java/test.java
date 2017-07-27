import com.recursion123.BaseApplication;
import com.recursion123.dao.UserDao;
import com.recursion123.model.Department;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseApplication.class})
public class test {

    @Autowired
    private UserDao userDaoSql;

    @Test
    public void testQuery() throws UnsupportedEncodingException {
        for(int i=0;i<1000;i++){
            System.out.println(userDaoSql.insertUser(
                    new User(new String(("用户4444"+i).getBytes("GBK"),"UTF-8"), "123", new Department(1, "研发部"), Arrays.asList(new Integer[]{1}))
            ));
        }

        //System.out.println(userDaoSql.listUser(null));

    }
}