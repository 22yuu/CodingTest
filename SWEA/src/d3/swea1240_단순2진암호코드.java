package d3;

import java.util.*;
import java.io.*;

public class swea1240_단순2진암호코드 {
	
	private static int T, N, M;
	private static String[] map;
	private static String[] secretCode = new String[] {
			"0001101",
			"0011001",
			"0010011",
			"0111101",
			"0100011",
			"0110001",
			"0101111",
			"0111011",
			"0110111",
			"0001011",
	};
	private static Map<String, Integer> hm = new HashMap<>();
	private static int[] convertArray;
	
	private static void initMap() {
		hm.put("0001101", 0);
		hm.put("0011001", 1);
		hm.put("0010011", 2);
		hm.put("0111101", 3);
		hm.put("0100011", 4);
		hm.put("0110001", 5);
		hm.put("0101111", 6);
		hm.put("0111011", 7);
		hm.put("0110111", 8);
		hm.put("0001011", 9);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			String target = "";
			
			N = Integer.parseInt(inputs[0]);
			M = Integer.parseInt(inputs[1]);
			
			map = new String[N];
			convertArray = new int[8];
			
			int answer = 0;
			
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine();
			}
			
			
			
			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < secretCode.length; j++) {
//					if(map[i].contains(secretCode[j])) {
//						
//						target = map[i];
//					}
//				}
				for(String key : hm.keySet()) {
					System.out.println(key);
					if(map[i].contains(key)) {
						
						target = map[i];
					}
				}
				
				if(!target.matches("")) break;
			}
			
			System.out.println(target);
			
//			String newTarget = "";
//			for(int i = 0; i < target.length(); i++) {
//				
//				if(target.charAt(i + 1) - '0' == 1) {
//					newTarget = target.substring(i, i + 56);
//					break;
//				}
//			}
			
//			System.out.println(newTarget.length());
//			System.out.println(newTarget);
			
//			String[] targetArray = newTarget.split("");
//			String temp = "";
//			
//			for(int i = 0; i < targetArray.length; i++) {
//				temp += targetArray[i];
//				if(temp.length() == 7) {
//					
//					temp = "";
//				}
//			}
//			
			
			
//			int oddSum = 0;
//			int evenSum = 0;
//			int sum = 0;
//			
//			for(int i = 0; i < 8; i++) {
//				
////				if(i % 2 == 0) oddSum += convertArray[i];
////				else evenSum += convertArray[i];
//				
////				if(convertArray[i] % 2 == 1) oddSum += convertArray[i];
////				else evenSum += convertArray[i];
//				
//				System.out.print(convertArray[i] + " ");
//			}
//			
//			System.out.println();
//			
//			sum = (oddSum * 3) + evenSum;
//			System.out.println("sum : " + sum);
//			if(((oddSum * 3)+ evenSum) % 10 == 0) answer = oddSum + evenSum; 
//			
//			System.out.printf("%d %d", test_case, answer);
		}
		
	}
}
