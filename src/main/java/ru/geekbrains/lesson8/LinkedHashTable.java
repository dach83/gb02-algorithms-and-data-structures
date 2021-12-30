package ru.geekbrains.lesson8;

public class LinkedHashTable<K, V> implements HashTable<K, V> {

    private final Item<K, V>[] data;
    private int size;

    public LinkedHashTable(int initCapacity) {
        this.data = new Item[initCapacity];
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    private Item<K, V> findItem(K key, Item<K, V> current) {
        while (current != null) {
            if (key.equals(current.key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Item<K, V> item = findItem(key, data[index]);
        if (item != null) {
            item.setValue(value);
        } else {
            item = new Item<>(key, value, data[index]);
            data[index] = item;
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Item<K, V> item = findItem(key, data[index]);
        if (item != null) {
            return item.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Item<K, V> parent = null;
        Item<K, V> current = data[index];
        while (current != null) {
            if (key.equals(current.key)) {
                break;
            }
            parent = current;
            current = current.next;
        }

        if (parent != null && current != null) {
            parent.next = current.next;
            current.next = null;
            return current.getValue();
        } else if (current != null) {
            data[index] = current.next;
            current.next = null;
            return current.getValue();
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------\n");
        for (int i = 0; i < data.length; i++) {
            sb.append("[" + i + "]: ");
            var item = data[i];
            while (item != null) {
                sb.append(item + "->");
                item = item.next;
            }
            sb.append("null\n");
        }
        sb.append("---------------------------------\n");
        return sb.toString();
    }

    private static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value, Item<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
