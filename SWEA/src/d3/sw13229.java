package d3;

import java.util.*;
import java.io.*;

public class sw13229 {
	
	private static HashMap<String, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		hm.put("MON", 1);
		hm.put("TUE", 2);
		hm.put("WED", 3);
		hm.put("THU", 4);
		hm.put("FRI", 5);
		hm.put("SAT", 6);
		hm.put("SUN", 7);
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String day = br.readLine();
			int answer = 0;
			
			if(day.equals("SUN")) {
				answer = hm.get(day); 
			} else {
				answer = 7 - hm.get(day);
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		
	}
}
