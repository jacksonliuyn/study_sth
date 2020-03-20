package study;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLData;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }



    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {

        return size() > capacity;
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
       LinkedHashMap<Integer, Integer> linkedHashMap =  new LinkedHashMap<>(10,0,true);
       StringBuffer sb  = new StringBuffer();
       List<Integer> list = new ArrayList<>();
       Collection<Object> objects = Collections.synchronizedCollection(new LinkedList<>());
       Stack<Integer> s = new Stack<>();

    }
}
