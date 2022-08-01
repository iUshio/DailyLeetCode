package dailyPromblem;

import java.util.*;

public class s146 {

    public static void main(String[] args) {
        LRUCache tmp = new LRUCache(2);
        
        System.out.println(tmp.get(2));
        tmp.put(2, 6);
        System.out.println(tmp.get(1));
        tmp.put(1, 5);
        tmp.put(1, 2);
        System.out.println(tmp.get(1));
        System.out.println(tmp.get(2));

    }

    static class LRUCache1 {

        Map<Integer, Integer> map;
        List<Integer> list;
        int capacity;

        public LRUCache1(int capacity) {
            map = new HashMap<>();
            list = new ArrayList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.remove(list.indexOf(key));
                list.add(key);
                return map.get(key);
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {

            if(map.containsKey(key)){
                map.put(key, value);

                list.remove(list.indexOf(key));
                list.add(key);
                return;
            }

            // 超出容量则弹出最久未使用
            if (list.size() + 1 > capacity && list.size() > 0) {
                map.remove(list.get(0));
                list.remove(0);
                
            }

            map.put(key, value);
            list.add(key);
        }
    }

    static class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        // 使用map来记录节点
        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        // 链表来更新位置
        private DLinkedNode head, tail;
    
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }
    
        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }
    
        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            }
            else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }
    
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
    
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }
    
        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

}
