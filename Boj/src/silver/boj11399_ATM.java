package silver;

import java.util.*;
import java.io.*;

public class boj11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		int sum = 0;
		for(int i = 0 ; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		for(int num : nums) {
			sum += num;
			answer += sum;
		}
		System.out.println(sum);
		System.out.println(answer);
		

	}

}
