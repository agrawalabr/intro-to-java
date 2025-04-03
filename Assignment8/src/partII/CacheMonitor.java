package partII;

public class CacheMonitor implements Runnable {

	LRUCache<Integer, Integer> lruCache;
	
	public CacheMonitor(LRUCache<Integer, Integer> lruCache) {
		this.lruCache = lruCache;
	}
	
	@Override
	public void run() {
		while(true) {
			if (this.lruCache.getCurrentCacheSize() > this.lruCache.getCacheCapacity()) {
				System.err.println("Error: max cache size exceeded");
			}
			Thread.yield();
		}
	}

}
