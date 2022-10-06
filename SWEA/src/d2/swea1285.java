package d2;

import java.util.*;
import java.io.*;

public class swea1285 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dists[] = new int[N];
			int min = Integer.MAX_VALUE;
			int answer = 0;
			
			
			// find min value
			for(int i = 0; i < N; i++) {
				int dist = Math.abs(0 - Integer.parseInt(st.nextToken()));
				if(min > dist) {
					min = dist;
				}
				dists[i] = dist;
			}
			
			// count people
			for(int i = 0; i < N; i++) {
				if(min == dists[i]) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d %d\n", test_case, min, answer);
		}
	}
}
