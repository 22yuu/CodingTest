package lv2;

import java.util.*;

// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BA%90%EC%8B%9C-Java

public class Ä³½Ã {
	
	 	static final int CACHE_HIT = 1;
	    static final int CACHE_MISS = 5;
	    
	    public static int solution(int cacheSize, String[] cities) {
	        if(cacheSize == 0) return 5 * cities.length;
	        
	        int answer = 0;
	        
	        LinkedList<String> cache = new LinkedList<>();
	        
	        for(int i = 0 ; i < cities.length ; ++i){
	            String city = cities[i].toUpperCase();
	            
	            // cache hit
	            if(cache.remove(city)){
	                cache.addFirst(city);
	                answer += CACHE_HIT;
	            
	            // cache miss
	            } else {
	                int currentSize = cache.size();
	                
	                if(currentSize == cacheSize){
	                    cache.pollLast();
	                }
	                
	                cache.addFirst(city);
	                answer += CACHE_MISS;
	            }
	        }
	        return answer;
	    }
	    
	    public static void main(String[] args) {
			int cacheSize = 3;
			String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
			
			System.out.println(solution(cacheSize, cities));
		}

}
