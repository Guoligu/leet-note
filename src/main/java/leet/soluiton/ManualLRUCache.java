package leet.soluiton;


import java.util.HashMap;
import java.util.Map;



public class ManualLRUCache {

    public static void main(String[] args) {
        int x = 0;
        ManualLRUCache lRUCache = new ManualLRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        x = lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        x = lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        x = lRUCache.get(1);    // 返回 -1 (未找到)
        x = lRUCache.get(3);    // 返回 3
        x = lRUCache.get(4);    // 返回 4
    }

    private final int capacity;
    private final Map<Integer, DoubleListNode> map;  // key, node
    private final DoubleList list;  // nodes

    public ManualLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {

            DoubleListNode node = map.get(key);
            list.remove(node);
            list.addLast(node);
            return node.val;
        } else {

            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            DoubleListNode node = map.get(key);
            node.val = value;
            list.remove(node);
            list.addLast(node);
        } else {

            if (list.size >= capacity) {
                DoubleListNode deletedNode = list.removeFirst();
                map.remove(deletedNode.key);
            }
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            list.addLast(node);
        }
    }
}

class DoubleListNode {
    int key;
    int val;
    DoubleListNode next;
    DoubleListNode prev;

    public DoubleListNode() {}

    public DoubleListNode(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class DoubleList {
    public DoubleListNode head;
    public DoubleListNode tail;
    public int size;

    public DoubleList() {
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(DoubleListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    public DoubleListNode removeFirst() {
        DoubleListNode deletedNode = head.next;
        remove(deletedNode);
        return deletedNode;
    }

    public int get(DoubleListNode node) {
        return node.val;
    }
}
