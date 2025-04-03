package partII;

public class Node<K, V> {
	private K key;
	private V value;
	private Node<K,V> next;
	private Node<K,V> prev;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public Node<K,V> getNext() {
		return this.next;
	}
	
	public void setNext(Node<K,V> n) {
		this.next = n;
	}
	
	public Node<K,V> getPrev() {
		return this.prev;
	}
	
	public void setPrev(Node<K,V> n) {
		this.prev = n;
	}
	

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
	
	

}
