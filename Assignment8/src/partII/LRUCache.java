package partII;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K,V> {
	
	HashMap<K,Node<K,V>> cache = new HashMap<>();
    DoublyLinkedList<K,V> lru_list = new DoublyLinkedList<>();
    int capacity = 10;
	int cacheSize = 0;
    
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
	

	public LRUCache() {
		this.capacity  = 10;
	}
	
	public LRUCache(int capacity) {
		this.capacity  = capacity;
	}
	
	public void clearCache() {
        writeLock.lock();
        try {
            cache.clear();
            lru_list.clear();
            cacheSize = 0;
        } finally {
            writeLock.unlock();
        }
    }
    
    public void put(K key, V value) {
        writeLock.lock();
        try {
            Node<K,V> node = cache.get(key);
            
            if (node != null) {
                node.setValue(value);
                lru_list.remove(node);
                lru_list.addFirst(node);
            } 
            else {
                node = new Node<>(key, value);
               
                if (cacheSize >= capacity) {
                    Node<K,V> evicted = lru_list.removeLast();
                    if (evicted != null) {
                        cache.remove(evicted.getKey());
                        cacheSize--;
                    }
                }

                cache.put(key, node);
                lru_list.addFirst(node);
                cacheSize++;
            }
        } 
        finally {
            writeLock.unlock();
        }
    }
	
    public V get(K key) {
        readLock.lock();
        try {
            Node<K,V> node = cache.get(key);
            if (node == null) {
                return null;
            }

            readLock.unlock();
            writeLock.lock();
            try {
                node = cache.get(key);
                if (node == null) {
                    return null;
                }
                lru_list.remove(node);
                lru_list.addFirst(node);
                return node.getValue();
            } finally {
                readLock.lock();
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
    
    public int getCurrentCacheSize() {
        readLock.lock();
        try {
            return this.cacheSize;
        } 
        finally {
            readLock.unlock();
        }
    }
	
	public int getCacheCapacity() {
		return this.capacity;
	}
	
	public String toStringList() {
		readLock.lock();
        try {
            return lru_list.toString();
        } 
        finally {
            readLock.unlock();
        }
	}
	
	public static void singleThreadTest(LRUCache<Integer,Integer> cache) {
		Random rand= new Random();
		int[] keys = new int[10];
		for (int i=0;i<10;i++) {
			int key = rand.nextInt();
			int val = rand.nextInt();
			keys[i] = key;
			System.out.println("adding key " + key + " and value " + val);
			cache.put(key, val);
			
		}
		System.out.println(cache.toStringList());
		for (int i=0;i<5;i++) {
			
			int idx = rand.nextInt(10);
			System.out.println("getting index " + idx + " with key " + keys[idx]);
			int val = cache.get(keys[idx]);
			System.out.println("value is " + val);
			System.out.println("lru list: " + cache.toStringList());
		}
		
		int key = rand.nextInt();
		int val = rand.nextInt();
		System.out.println("adding key " + key + " and value " + val);
		cache.put(key, val);
		System.out.println("lru list: " + cache.toStringList());
	}
	
	public static void main(String[] args) {

		LRUCache<Integer,Integer> cache = new LRUCache<>();
		singleThreadTest(cache);
		
		cache.clearCache();
		CacheMonitor cm = new CacheMonitor(cache);
		Thread cmThread = new Thread(cm);
		cmThread.start();
		for (int i=0;i<5;i++) {
			CacheRunner cr = new CacheRunner(cache);
			Thread crThread = new Thread(cr);
			crThread.start();
		}
	}
}
