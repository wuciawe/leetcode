package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haha on 2015/5/2.
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if( !map.containsKey(key) ) {
            return -1;
        }
        Node n = map.get(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
        return n.val;
    }

    public void set(int key, int value) {
        Node n;
        if( map.containsKey(key) ) {
            n = map.get(key);
            n.val = value;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            map.remove(key);
        }else{
            if( map.size() == capacity ){
                Node last = tail.prev;
                map.remove(last.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
            n = new Node(key, value);
        }
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
        map.put(key, n);
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
