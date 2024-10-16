/* https://www.naukri.com/code360/problems/lru-cache-implementation_670276?
    topList=top-uber-coding-interview-questions&problemListRedirection=true&company%5B%5D=Uber */

package linear;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class LRUCache {

    Map<Integer, String> cache = null;
    final int capacity = 0;

    LinkedList<Integer> order = new LinkedList<Integer>();

    LRUCache(int capacity)
    {
        cache = new HashMap<>(capacity);
    }

    private void evict() {
        int evictionKey  = order.getLast();
        cache.remove(evictionKey);
    }

    private void checkCacheTolerance() {

        if(cache.size()/capacity>=0.8) {
            evict();
        }
    }

    public String get(int key)
    {
        String data = cache.get(key)==null?"": cache.get(key);

        return data;
    }

    public void put(int key, String value)
    {
        checkCacheTolerance();
        if(cache.get(key) != null) {
            cache.put(key,value);
        }
        order.addFirst(key);
    }

    public static void main(String[] args) {

            LRUCache cache = new LRUCache(3);
            cache.put(1, "one");
            cache.put(2, "two");
            cache.put(3, "three");
            cache.put(4, "four"); // putting new cache when full. 1 will be removed
            cache.get(3); // accessing 3, it will be moved to top
            cache.get(2);// accessing 2, it will be moved to top
            cache.put(1, "one"); // putting new cache when full. 4 will be removed
            cache.get(3);// accessing 3, it will be moved to top
            cache.get(1);// accessing 1, it will be moved to top
            //cache.display(); // 1 should be on top
            /*
             * output
             * 1 => one
             * 3 => three
             * 2 => two
             *
             **/
    }
}
