package silver;

import java.util.*;
import java.io.*;

public class boj3273_두수의합 {
	
	private static HashMap<Integer, Integer> hm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		hm = new HashMap<>();
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int target = Integer.parseInt(br.readLine());
		
//		for(int i = 0; i < N; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			
//			if(hm.containsKey(num)) answer++;
//			hm.put(target - num, i);
//		}
		
		int left = 0;
		int right = N - 1;
		int nums[] = new int[N];
		
		for(int i = 0 ; i < N ; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
//		for(int num : nums) System.out.print(num + " ");
		
		while(left < right) {
			
			int sum = nums[left] + nums[right];
			
			if(sum == target) {
				answer++;
				left++;
				right--;
			} else if(sum > target) {
				right--;
			} else {
				left++;
			}
			
		}
		
		
		System.out.println(answer);

	}

}
