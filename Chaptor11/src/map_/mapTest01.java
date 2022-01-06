package map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapTest01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("sg","guoxuefei!");
        map.put(null, null);   //k-v
        map.put(null, "abc");  //替换
        System.out.println(map.get(null));
        System.out.println(map.get("sg"));

        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());

    }
}
