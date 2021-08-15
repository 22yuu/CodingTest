package silver;

import java.util.*;
import java.io.*;

public class boj14501_Επ»η {

	static int N;
	static int[] P;
	static int[] T;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		P = new int[N+5];
		T = new int[N+5];
		dp = new int[N+5];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i <= N+1; i++) {
			int idx = i + T[i];
			
			if(idx <= N+1) {
				dp[i] = Math.max(dp[i+1], P[i] + dp[idx]);
			} 
			dp[i] = Math.max(dp[i], dp[i+1]); // dp[i] = dp[i+1];
			
			System.out.println(i+" "+dp[i]);
		}
		System.out.println(dp[1]);
	}
}
