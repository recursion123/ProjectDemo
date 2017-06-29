import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/20.
 */
public class test3 {

    @Test
    public void test() {
        String json = "{a:'a',b:[{x:'x'},{n:'n'},'m','n',[{a:'a'},'b']],c:{y:'y'}}";
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        System.out.println(gson.toJson(toUpperCaseForMap(map)));
    }

    public Map toUpperCaseForMap(Map map) {
        Map result = new LinkedHashMap();
        map.forEach((k, v) -> {
            if (v instanceof Map) {
                result.put(k.toString().toUpperCase(), toUpperCaseForMap((Map) v));
            } else if (v instanceof List) {
                result.put(k.toString().toUpperCase(), toUpperCaseForList((List) v));
            } else {
                result.put(k.toString().toUpperCase(), v);
            }
        });
        return result;
    }

    public List toUpperCaseForList(List list) {
        List tempList = new ArrayList();
        list.forEach(item -> {
            if (item instanceof Map) {
                tempList.add(toUpperCaseForMap((Map) item));
            } else if (item instanceof List) {
                tempList.add(toUpperCaseForList((List) item));
            } else {
                tempList.add(item);
            }
        });
        return tempList;
    }

}
