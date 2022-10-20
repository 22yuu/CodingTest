package silver;

import java.util.*;
import java.io.*;

public class boj1940_주몽 {

	private static int N, M;
	private static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		nums = new int[N];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = N - 1;
		
		while(left < right) {
			
			int sum = nums[left] + nums[right];
			
			if(sum == M) {
				answer++;
				left++;
				right--;
			} else if(sum > M) {
				right--;
			} else {
				left++;
			}
		}
		
		System.out.println(answer);
	}

}
