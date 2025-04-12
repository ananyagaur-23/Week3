import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];

        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];

        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];

        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                list.remove(entry);
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];

        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
