package d3;

import java.util.*;
import java.io.*;

public class sw13428 {
	
	private static String[] nums;
	private static int MAX;
	private static int MIN;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String numStr = br.readLine();
			nums = numStr.split("");
			MAX = Integer.parseInt(numStr);
			MIN = Integer.parseInt(numStr);
			
			for(int i = 0; i < nums.length; i++) {
				for(int j = i + 1; j < nums.length; j++) {
					swap(i, j);
					if(nums[0].equals("0")) {
						swap(i,j); // 원위치
						continue;
					}
					getMinMax();
					swap(i, j); // 원위치
				}
			}
			
			System.out.printf("#%d %d %d\n", test_case, MIN, MAX);
		}
	}
	
	public static void swap(int a, int b) {
		String temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void getMinMax() {
		StringBuilder sb = new StringBuilder();
		for(String n : nums) sb.append(n);
		
		int num = Integer.parseInt(sb.toString());
		
		MAX = Math.max(MAX, num);
		MIN = Math.min(MIN, num);
	}
}
