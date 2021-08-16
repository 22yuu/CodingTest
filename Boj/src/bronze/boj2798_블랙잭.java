package bronze;

import java.util.*;
import java.io.*;

public class boj2798_∫Ì∑¢¿Ë {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int min = Integer.MAX_VALUE;
		int result = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j <N; j++) {
				for(int k = j+1; k < N; k++) {
					sum = nums[i] + nums[j] + nums[k];
					
					if(sum > M) {
						continue;
					} else {
						if((M - sum) < min) {
							min = M - sum;
							result = sum;
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
