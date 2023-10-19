package v2;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public class Pair<K, V> {

    private K key;
    private V value;

    /**
     * Constructor of Pair
     * @param key
     * @param value
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get key
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * Get value
     * @return value
     */
    public V getValue() {
        return value;
    }

    /**
     * Set key
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Set value
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }
}
