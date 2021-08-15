package silver;

import java.util.*;
import java.io.*;

public class boj1149_RGB°Å¸® {
	
	static int N;
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][3];
		int colors_cost[][] = new int[N+1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				colors_cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			dp[i][0] = colors_cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = colors_cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = colors_cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}
