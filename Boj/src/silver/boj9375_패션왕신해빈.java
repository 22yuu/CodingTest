package silver;

import java.util.*;
import java.io.*;

public class boj9375_�мǿս��غ� {

	private static HashMap<String, String> hm = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int countGears = 0;
			int answer = 0;
			
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken(); // �����۵� ���� ���۶� �͹� ��
				String gear = st.nextToken(); // ��� ���� ���� �Ӹ� �� �ٵ�
				
				
				
				if(!hm.containsKey(gear)) {
					hm.put(gear, item);
					countGears++;
				} else {
					hm.put(gear, hm.get(gear) + " " + item);
				}
			}// end for
			
		    int[] gears = new int[countGears];
	        int index = 0;
	        
//	        System.out.println(hm.size());
//	        System.out.println(countGears);
	        
	        for(String g: hm.keySet()) {
	            String[] cloth = hm.get(g).split(" ");
	            gears[index] = cloth.length+1; // +1�� ���ִ� ������ �ƹ��͵� ���� �ʾ��� ��
//	            System.out.println("count gears :" + gears[index]);
	            index++;
	        }
	        
	        
	        if(hm.size() > 1) {
	            for(int num : gears) answer *= num;
	            answer -= 1;
	        } else {
	            answer = countGears * n;
	        }
	        
	        System.out.println(answer);
			
		} // test case for

	}

}
