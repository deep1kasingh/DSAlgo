package leetcode.amazon;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private Deque<Node> queueOfNodes;
    private int capacity;
    private Map<Integer, Node> keyNodeMap;

    private static class Node {
        int val;
        int key;
        Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        queueOfNodes = new LinkedList<>();
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>();
    }

    public int get(int key) {
        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            modeNodeToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            node.val = value;
            modeNodeToHead(node);
        } else {
            if(keyNodeMap.size() >= capacity) {
                Node node = queueOfNodes.removeLast();
                keyNodeMap.remove(node.key);
            }
            addNodeToHead(key, value);
        }
    }

    private void modeNodeToHead(Node node){
        queueOfNodes.remove(node);
        queueOfNodes.addFirst(node);
    }

    private void addNodeToHead(int key, int value){
        Node node = new Node(key, value);
        queueOfNodes.addFirst(node);
        keyNodeMap.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
        System.out.print("deepika");
    }
}
