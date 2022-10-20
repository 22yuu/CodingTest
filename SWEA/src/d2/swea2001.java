package d2;

import java.io.*;
import java.util.*;

public class swea2001 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
		
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// end map array initalization 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = 0;
					if(i + M > N || j + M > N ) continue;
					
					for(int k = i; k < i+M; k++) {
						for(int h = j; h < j+M; h++) {
//							System.out.print(map[k][h] + " ");
							sum += map[k][h];
						}
					}
//					System.out.println();
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#"+test_case+" "+max);
		} // for end
	} // main end

}
