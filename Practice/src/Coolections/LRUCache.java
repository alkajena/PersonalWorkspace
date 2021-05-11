package Coolections;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LRU{
	
	public int capacity;
	public LinkedHashSet<Integer> set;
	public Deque<Integer> cache;
	
	public LRU(int capacity){
		this.capacity=capacity;
		set=new LinkedHashSet<>(capacity);
		cache=new LinkedList<>();
	}
	
	public void look(int key){
		//if key is present then remove from cache as it should be added to front of dqueue
		if(set.contains(key)){
			cache.remove(key);
		}
		else{
			//if cache reaches the capacity then remove the last element from cache and set both
			if(cache.size()==this.capacity){
				int last=cache.removeLast();
				set.remove(last);
			}
		}
		
		//add key to set and cache as well
		cache.push(key);
		set.add(key);
	}
}