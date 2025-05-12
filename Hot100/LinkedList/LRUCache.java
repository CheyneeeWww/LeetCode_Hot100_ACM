package LeetCode.Hot100.LinkedList;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author cnwang
 * @Date created in 13:17 2025/5/12
 */
public class LRUCache {
    int capacity;
    Map<Integer,Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        Integer value = cache.remove(key);
        if(value!=null){
            cache.put(key,value);
        }
        return -1;
    }

    public void put(int key,int value){
        if(cache.remove(key)!=null){
            cache.put(key,value);
        }

        if(cache.size() == capacity){
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey);
        }
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 输出 1
        lruCache.put(3, 3); // 删除键 2
        System.out.println(lruCache.get(2)); // 输出 -1
    }
}
