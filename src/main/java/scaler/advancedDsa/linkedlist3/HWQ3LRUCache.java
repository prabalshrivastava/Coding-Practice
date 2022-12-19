package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;

import java.util.AbstractMap;
import java.util.HashMap;

public class HWQ3LRUCache {
    //    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//            get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//    set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
//    The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
//    Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
//            NOTE: If you are using any global variables, make sure to clear them in the constructor.
//    Example :
//    Input :
//    capacity = 2
//    set(1, 10)
//    set(5, 12)
//    get(5)        returns 12
//    get(1)        returns 10
//    get(10)       returns -1
//    set(6, 14)    this pushes out key = 5 as LRU is full.
//    get(5)        returns -1
    public static void main(String[] args) {
//        HWQ3LRUCache hwq2PartitionList1 = new HWQ3LRUCache();
//        LinkedListUtils.print_ll(hwq2PartitionList1.partition(LinkedListUtils.addFromArrayAndPrint(new int[]{2,3,3,3}, hwq2PartitionList1.head), 2));
    }

    class Node {
        AbstractMap.Entry<Integer, Integer> pair;
        Node next;
        Node prev;

        Node(int key, int value) {
            pair = new AbstractMap.SimpleEntry<>(key, value);
        }
    }

    HashMap<Integer, Node> hm;
    int capacity;
    Node dummyHead;
    Node dummyTail;

    public HWQ3LRUCache(int capacity) {
        hm = new HashMap<>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hm.get(key);
        if (node == null) {
            return -1;
        } else {
            remove(node);
            addToTail(node);
            return node.pair.getValue();
        }
    }

    public void set(int key, int value) {
        Node newNode = new Node(key, value);
        Node node = hm.get(key);
        if (node == null) {
            if (hm.size() == capacity) {
                //remove the first element;
                remove(dummyHead.next);
            }
//            newNode.next = dummyTail;
//            newNode.prev = dummyTail.prev;
//            dummyTail.prev.next = newNode;
//            dummyTail.prev = newNode;
            addToTail(newNode);
//            hm.put(key, newNode);
        } else {
            //remove node
//            Node next = node.next;
//            Node prev = node.prev;
//            prev.next = next;
//            next.prev = prev;
            remove(node);

            //insert at the end.
//            prev = dummyTail.prev;
//            next = dummyTail;
//            prev.next = node;
//            next.prev = node;
//            node.next = next;
//            node.prev = prev;
            addToTail(newNode);
//            hm.put(key, node);
        }
    }

    void remove(Node x) {
        Node next = x.next;
        Node prev = x.prev;
        prev.next = next;
        next.prev = prev;
        hm.remove(x.pair.getKey());
    }

    void addToTail(Node x) {
        Node prev = dummyTail.prev;
        Node next = dummyTail;
        x.prev = prev;
        x.next = next;
        next.prev = x;
        prev.next = x;
        hm.put(x.pair.getKey(), x);
    }
}
