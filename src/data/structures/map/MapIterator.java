package data.structures.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {
    //use iterator
    //we can also remove entries from the map during ieration by calling iterator.remove() method
    public void iterateMap(Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }

    //use for iteration
    //most common
    public void iterateMapII(Map<Integer, String> map){
        //using keySet() for iteration over keys
        for (Integer id : map.keySet()) {
            System.out.println("key: " + id);
        }
        //using values() for iteration over values
        for (String name : map.values()) {
            System.out.println("value: " + name);
        }
    }
    //use for iteration
    //most common
    public void iterateMapIII(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    //use lambda expression forEach(action) method to iterate map
    //clean and fast
    public void iterateMapIV(Map<String, String> map) {
        map.forEach((k,v) -> System.out.println("key: " + k + " value: " + v));
    }


}
