package silver;

import java.util.*;
import java.io.*;

public class boj11047_µ¿Àü0 {

	private static int N, K;
	private static int coins[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		coins = new int[N+1];
		
		int answer = 0;
		
		for(int i = 1; i <= N; i++) coins[i] = Integer.parseInt(br.readLine());
		
		
		int idx = N;
		while(K > 0) {
			
			if(K / coins[idx] == 0) {
				idx--;
				continue;
			}
			
			answer += K / coins[idx];
			K %= coins[idx];
			
			idx--;
		}
		
		System.out.println(answer);
	}
}
