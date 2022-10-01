package d2;

import java.util.*;
import java.io.*;

public class swea1979 {
	
	public static int[][] map;
	public static int N, K, answer;
	
	public static void SearchWidth() {
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(map[j][i] == 0) {
					// 0을 만났을 때 
					if(count == K) answer++; // 현재 count와 K 값이 동일하다면 answer 증가
					 count = 0;
				}
				else {
					count++;
				}
			}
			if(count == K) answer++;
			count = 0;
		}
	}
	
	public static void SearchHeight() {
			
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(map[i][j] == 0) {
						// 0을 만났을 때 
						if(count == K) answer++; // 현재 count와 K 값이 동일하다면 answer 증가
						 count = 0;
					}
					else {
						count++;
					}
				}
				// 행이 바뀌면 count를 0으로
				if(count == K) answer++;
				count = 0;
			}
		}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로 탐색
			SearchWidth();
			// 세로 탐색
			SearchHeight();
			
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
	} // end main 
	
	public static void print(int N) {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
