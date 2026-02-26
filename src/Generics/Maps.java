package Generics;

interface Map<K , V> {
    void set(K key, V value);
    K getKey();
    V getValue();

}
class SimpleMap<K , V> implements Map<K,V> {
    private K key;
    private V value;

    @Override
    public void set(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

}

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new SimpleMap<>();
        map.set(1, "Alpha");
        System.out.println(map.getKey() + map.getValue());
    }
}

