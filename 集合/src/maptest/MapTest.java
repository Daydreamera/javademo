package maptest;

import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void hashMapTest() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("one", 1);
        hm.put("three", 3);
        hm.put("eleven", 11);
        hm.put("twelve", 12);
        hm.put("nine", 9);



        // 无序输出
        hm.entrySet().stream().map(k -> k.getKey() + ":" + k.getValue()).forEach(System.out::println);
    }

    @Test
    public void linkHashMapTest() {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("one", 1);
        lhm.put("three", 3);
        lhm.put("eleven", 11);
        lhm.put("twelve", 12);
        lhm.put("nine", 9);
        // 有序输出
        lhm.keySet().stream().map(k -> k + ":" + lhm.get(k)).forEach(System.out::println);
    }
}
