package silver;

import java.util.*;
import java.io.*;

public class boj2559_수열 {

	private static int N, K, MAX;
	private static int[] temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAX = Integer.MIN_VALUE;
		
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 2) {
			if( K  == 2) {
				System.out.println(temp[0] + temp[1]);
				return;
			}
			
			if( K == 1) {
				if(temp[0] > temp[1]) System.out.println(temp[0]);
				else System.out.println(temp[1]);
				return;
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			
			for(int j = 0; j < K; j++) {
				if( i + j > N - 1) break;
				sum += temp[i+j];
				System.out.println(sum);
			}
//			System.out.println(sum);
			MAX = Math.max(MAX, sum);
		}
		
		System.out.println(MAX);
	}

}
