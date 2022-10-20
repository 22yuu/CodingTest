package silver;

import java.util.*;
import java.io.*;

public class boj1744_¼ö¹­±â {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
//		for(int num : nums) System.out.print(num + " ");
		
//		System.out.println();
		
		long answer = 0;
		for(int i = N-1; i >= 0; ) {
			
			if(nums[i] > 0 && nums[i-1] > 0) {
//				System.out.println("else if 1: " + nums[i] + " " + nums[i-1]);
				
				if(nums[i] == 1 && nums[i-1] == 1) {
					answer += nums[i] + nums[i-1];
					i -= 2;
					continue;
				}
				
				answer += nums[i] * nums[i-1];
				i = i - 2;
				continue;
			} else if(i >= 1 && nums[i] <= 0 && nums[i-1] <= 0) {
//				System.out.println("else if 2:" + nums[i] + " " + nums[i-1]);
				
				answer += nums[i] * nums[i-1];
				i = i - 2;
				continue;
			}else {
//				System.out.println("else : " +nums[i]);
				answer += nums[i];
				i--;
			}
		}
		
		System.out.println(answer);

	}

}
