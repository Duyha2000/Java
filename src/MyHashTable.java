public class MyHashTable<K, V> {
    // https://docs.google.com/document/d/17OBpdk-gXOAg0BtTn7-8XmX7sW2DY6RMS4O89KYECIg/edit?tab=t.0
    // Hashmap -> 'Hashtable'
    // [Pho tai] <-> [30000]
    // [Pho bo] <-> [35000]
    // pair ->  key - value: [Pho tai -> 300000]
    // thống kê tần số số lần xuất hiện
    // 3 ->
    // 1: 0
    // 2: 2
    // 4: 6 (+1 value)

    // 3: 1 (tao 1 key moi - so lan xuat hien la 1)

    // Pho - 30000 , Bun bo - 40000, Bun dau- 50000

    // hash table (capacity = 16): ... ... ... ...
    // index: 0 -> 15
    //bucket [ [Pho - 30000-next, Bun bo - 40000-null] [] [] [ Bun dau- 50000] [] [] [] []  ]
    // linked list -> Node (key, value, next)
    private Node[] buckets;
    private int capacity; // 10
    private int size; // 7

    // 1000 ml // 750ml (900)

    public MyHashTable() {
        this.capacity = 16;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    // getIndex hashCode() - pho -> 3500393 | bun bo: [-2818182882]
    // 0 -> 24h

    // 'pho' -> hashCode() -> '3500393' -> index 5
    // 'bun bo' -> hashCode() -> '-2818182882' -> index 5
    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity; // [0 - 15]
    }

    // add, update (PUT) -> key nay ton tai -> +1 value
    //                   -> key chua ton tai -> key moi, value la 1

    // put (Pho, 40000)
    // put (Bun ca, 50000) -> 5
    // [] [] [] [] [] [head -> (Pho-40000,next),(Bun Bo- 400000,null)] [] [] [] [] ...[]
    public void put(K key, V value) {
        int index = getIndex(key); // Pho -> index 5
//        Node<K, V> head = buckets[index];
        // update:
        for (Node current = buckets[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value; //
                return;
            }
        }
        // add:
        Node<K, V> newNode = new Node<>(key, value);
        buckets[index] = newNode; // head = newNode; -> add first
        size++;
        // -> loadFactor
        float loadFactor = 0.75f;
        if ((float) size / capacity > loadFactor) rehash();
    }

    // delete
    public void remove(K key) {
        int index = getIndex(key); // 5
        Node<K, V> head = buckets[index];
        // delete first
        if (head != null && head.key.equals(key)) {
            buckets[index] = head.next;
            size--;
        }
        // delete mid/last
        // remove C
        //    'current'
        // A - B(next) - C(x) - D
        for (Node<K, V> current = head; current != null && current.next != null; current = current.next) {
            if (current.next.key.equals(key)) {
                current.next = current.next.next;
                size--;
                return;
            }
        }

    }

    // get value from key
    public V getValue(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];
        for (Node<K, V> current = head; current != null; current = current.next) {
            if (current.key.equals(key)) return current.value;
        }
        return null;
    }

    public int size() {
        return size;
    }

    // CONTAINS
    public boolean containsKey(K key) {
        return getValue(key) != null;
    }
    // [0 -> 12] (13h - 24h)
    // 20 % [12] = 8
    // 23 % [12] = 11

    // 🔄 8. Xử lý mở rộng (rehash)
//    Khi: số phần tử > loadFactor × capacity
//    → Tạo mảng mới có kích thước gấp đôi.
//    Duyệt toàn bộ hash table cũ, tính lại hash và chèn vào mảng mới.
    private void rehash() {
        Node<K, V>[] oldBucket = buckets;
        buckets = new Node[capacity * 2];
        capacity *= 2; //
        for (Node<K, V> node : oldBucket) {
            for (Node<K, V> p = node; p != null; p = p.next) {
                put(p.key, p.value);
            }
        }
    }
}
