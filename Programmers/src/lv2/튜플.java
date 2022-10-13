package lv2;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Æ©ÇÃ {
	 	public static HashMap<Integer, Integer> hm = new HashMap<>();
	    public static List<Integer> list = new ArrayList<>();
	    
	    public static int[] solution(String s) {
	        // int[] answer = {};
	        
	        String str = s.replace("{","");
	        str = str.replace("}","");
	        // System.out.println(str);
	        
	        String nums[] = str.split(",");
	        
	        for(String num : nums) {
	            int hmKey = Integer.parseInt(num);
	            
	            if(hm.get(hmKey) == null) hm.put(hmKey, 0);
	            else {
	                hm.put(hmKey, hm.get(hmKey) + 1);
	            }
	        }
	        
	        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(hm.entrySet());
	        
	        Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
	           
	            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
	                return obj2.getValue().compareTo(obj1.getValue());
	            }
	        });
	        
	        for(Entry<Integer, Integer> entry: list_entries) {
	            // System.out.println(entry.getKey() + " : " + entry.getValue());
	            list.add(entry.getKey());
	        }
	        
	        int length = list.size();
	        int[] answer = new int[length];
	        
	        for(int i = 0; i < length; i++) {
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	    
	    
	    public static void main(String[] args) {
		    System.out.println(print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
	    }
	    
	    public static String print(int[] arr) {
	    	String str ="[";
	    	
	    	for(int i = 0; i < arr.length; i++) {
	    		if(i == arr.length - 1) {
	    			str += arr[i];
	    			break;
	    		}
	    		str += arr[i] + ",";
	    	}
	    	
	    	return str + "]";
	    }

}
