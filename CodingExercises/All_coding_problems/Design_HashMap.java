class Node{
    int key;
    int val;
    Node next;
    Node(int key, int val){ this.key = key; this.val = val; this.next=null;}
}

class MyHashMap {
    Node[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Node[1000];
    }
    
    private int hashFunction(int key){
        return key%1000;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashFunction(key);
        if(map[index]==null){
            map[index] = new Node(-1,-1);
        }
        Node head = map[index];
        while(head.next!=null && head.next.key!=key){
            head = head.next;
        }
        if(head.next!=null){ head.next.val = value;}
        else{head.next=new Node(key, value); }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunction(key);
        if(map[index]==null)
            return -1; 
        Node head = map[index];
        while(head.next!=null && head.next.key!=key){
            head = head.next;
        }
        if(head.next!=null){ return head.next.val;}
        else{ return -1;}
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunction(key);
        if(map[index]==null) return;
        Node head = map[index];
        while(head.next!=null && head.next.key!=key){
            head = head.next;
        }
        if(head.next!=null){ head.next=head.next.next;}
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */