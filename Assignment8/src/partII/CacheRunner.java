package partII;
import java.util.LinkedList;
import java.util.Random;

public class CacheRunner implements Runnable {
	private static int nextId = 0;
	private int id;
	LRUCache<Integer, Integer> lruCache;
	
	public CacheRunner(LRUCache<Integer,Integer> lruCache) {
		this.id = nextId++;
		this.lruCache = lruCache;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public void run() {
		LinkedList<Integer> keys = new LinkedList<>();
		Random rand = new Random();
		while (true) {
			if (rand.nextBoolean()) {
				int key = rand.nextInt();
				int val = rand.nextInt();
				lruCache.put(key, val);
				System.out.println("Runner " + id + ": adding k,v " + key + ", value to cache");
				if (keys.size() > 5) {
					keys.removeFirst();
				}
				keys.addLast(key);
			} else if (keys.size() > 0) {
				int key = keys.get(rand.nextInt(keys.size()));
				Integer result = lruCache.get(key);
				if (result == null) {
					System.out.println("Runner " + id + ": cache miss for key " + key);
				} else {
					System.out.println("Runner " + id + ": cache hit for key " + key +", value = " + result);
				}
			}
			try {
				Thread.sleep(rand.nextInt(20));
				Thread.yield();
			} catch (InterruptedException e) {
				System.err.println("Runner " + id + ": " + e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
