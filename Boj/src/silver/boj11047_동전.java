package silver;

import java.util.*;
import java.io.*;

public class boj11047_동전 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전의 수(가치)
		int K = Integer.parseInt(st.nextToken()); // 만들어야하는 가격
		
		Integer[] prices = new Integer[N];
		//int[] prices = new int[N];
		
		for(int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(prices, Collections.reverseOrder());
		int count = 0;
		
		while(K > 0) {
			
			for(int i = 0; i < N; i++) {
				if((K/prices[i]) > 0) {
					int coins = K/prices[i]; 
					count +=  coins;
					K = K - (coins * prices[i]);
				}
			}
			
		}
		
		System.out.println(count);
		
		
		
	}
}
