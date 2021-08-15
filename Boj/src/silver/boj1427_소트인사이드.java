package silver;

import java.util.*;
import java.io.*;

public class boj1427_소트인사이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Integer nums[] = new Integer[str.length()];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i =0; i < str.length(); i++) {
			nums[i] = str.charAt(i) - '0';
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		for(Integer num : nums) sb.append(num); 
		System.out.println(sb);
	}
}
