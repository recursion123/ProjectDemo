import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class test4 {
    @Test
    public void test(){
        String json="[{'id':'20130717001','ids':'20130717001','data':{'name':'张三','age':'18','idNumber':'429006198808081313','sex':'男'}}]";
        List list=new Gson().fromJson(json, List.class);
        System.out.println(((Map)list.get(0)).get("id"));
    }
}
