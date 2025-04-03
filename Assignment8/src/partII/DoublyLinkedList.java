package partII;

public class DoublyLinkedList<K, V> {

	Node<K,V> head;
	Node<K,V> tail;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void addFirst(Node<K,V> newNode) {
        newNode.setPrev(null);
        newNode.setNext(null);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

	
	public void clear() {
		this.head = null;
		this.tail = null;
	}
	
	public void addLast(Node<K,V> newNode) {
        newNode.setPrev(null);
        newNode.setNext(null);
        
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }
	
	public Node<K,V> remove(Node<K, V> n) {
        if (n == null) {
            return null;
        }
        
        if (n == head) {
            head = n.getNext();
        } else {
            if (n.getPrev() != null) {
                n.getPrev().setNext(n.getNext());
            }
        }
        
        if (n == tail) {
            tail = n.getPrev();
        } else {
            if (n.getNext() != null) {
                n.getNext().setPrev(n.getPrev());
            }
        }
        
        n.setPrev(null);
        n.setNext(null);
        
        return n;
    }
	
	public Node<K,V> removeLast() {
        if (tail == null) {
            return null;
        }
        
        Node<K,V> lastNode = tail;
        
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        
        lastNode.setPrev(null);
        lastNode.setNext(null);
        
        return lastNode;
    }
	
	public String toString() {
		StringBuilder outString = new StringBuilder("[");
		Node<K,V> currentNode = this.head;
		while (currentNode != null) {
			outString.append(currentNode.toString());
			if (currentNode.getNext() != null) {
				outString.append(" - ");
			}
			currentNode = currentNode.getNext();
		}
		outString.append("]");
		return outString.toString();
	}
	
}
