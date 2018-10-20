package collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    测试 ConcurrentHashMap
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        Map<String,String> map2 = new HashMap<String, String>();
         Collections.synchronizedMap(map2);
    }

}
