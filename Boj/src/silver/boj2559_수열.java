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

		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			
			for(int j = i; j < i+K; j++) {
				if( j > N - 1) {
					System.out.println(MAX);
					return;
				}
				sum += temp[j];
//				System.out.println(sum);
			}
//			System.out.println(sum);
			MAX = Math.max(MAX, sum);
		}
		
		System.out.println(MAX);
	}

}
