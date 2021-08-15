package silver;

import java.util.*;
import java.io.*;

public class boj2579_계단오르기 {

	public static int N;
	public static int nums[];
	public static int dp[];
	
	public static int step(int idx) {
		
		if(idx == N) {
			return dp[idx];
		}
		dp[idx] = Math.max(dp[idx-2], dp[idx - 3] + nums[idx-1]) + nums[idx];
		return step(idx + 1);
 	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = nums[0];
		dp[1] = nums[1];
		
		if(N >= 2) {
			dp[2] = nums[1] + nums[2];
		}
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i - 3] + nums[i-1]) + nums[i];
		}
		
		System.out.println(dp[N]);
	}
}
