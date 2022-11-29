package gold;

import java.util.*;
import java.io.*;

public class boj1286_평범한배낭 {
	
	private static int N, K; // 물품 수, 버틸 수 있는 무게
	private static int[][] items;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);
		
		items = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		// init items array
		for(int i = 1; i <= N; i++) {
			inputs = br.readLine().split(" ");
			items[i][0] = Integer.parseInt(inputs[0]);
			items[i][1] = Integer.parseInt(inputs[1]);
		}
		
		for(int i = 1; i <= K; i++ ) {
			for(int j = 1 ; j <= N ; j++) {
				dp[j][i] = dp[j - 1][i];
				
				if(i - items[j][0] >= 0) 
					dp[j][i] = Math.max(dp[j-1][i], items[j][1] + dp[j - 1][i - items[j][0]]);
//				System.out.print(dp[j][i]);
			}
//			System.out.println();
		}
		
		System.out.println(dp[N][K]);
		
	}

}
