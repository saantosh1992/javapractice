package com.icode.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public Node(){

    }
}

public class LRUCache<K, V> implements Cache<K, V> {

    private Map<K, Node<K, V>> nodeMap;
    private int size;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int size) {
        this.size = size;
        nodeMap = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node<K, V> node) {
        Node<K, V> nextNode = node.next;
        Node<K, V> prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    public void add(Node<K, V> node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    @Override
    public boolean put(K key, V value) {

      Node<K, V> node = nodeMap.get(key);
      if(node != null) {
          node.value = value;
          remove(node);
          add(node);
      } else {
          if (nodeMap.size() == size) {
              nodeMap.remove(tail.prev.key);
              remove(tail.prev);
          }
          Node<K, V> newNode = new Node<>(key, value);
          nodeMap.put(key, newNode);
          add(newNode);
      }

        return false;
    }

    @Override
    public Optional<V> get(K key) {

        Node<K, V> node = nodeMap.get(key);
        if(node != null) {
            remove(node);
            add(node);
            return Optional.of(node.value);
        }

        return Optional.empty();
    }

    @Override
    public int size() {
        return nodeMap.size();
    }

    @Override
    public boolean isEmpty() {
        return nodeMap.isEmpty();
    }

    @Override
    public void clear() {
        nodeMap.clear();
    }

    public static void main(String[] args) {
        System.out.println("Going to test the LRU "
                + " Cache Implementation");
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.put(1, 10);

        // it will store a key (1) with value 10 in the
        // cache.
        cache.put(2, 20);
        System.out.println("Value for the key: 1 is "
                + cache.get(1)); // returns 10

        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.put(3, 30);

        System.out.println(
                "Value for the key: 2 is "
                        + cache.get(2)); // returns -1 (not found)

        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.put(4, 40);
        System.out.println(
                "Value for the key: 1 is "
                        + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is "
                + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is "
                + cache.get(4)); // return 40
    }
}
