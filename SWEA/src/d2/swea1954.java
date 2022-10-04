package d2;

import java.util.*;
import java.io.*;

public class swea1954 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
//			print(map);
			
			int x = -1;
			int y = 0;
			int value = 0;
			int dir = 1; // 0 : 오른쪽 / 1 : 아래 / 2 : 왼 / 3: 위
			
			while(true) {
				
				for(int i = 0; i < N; i++) {
					x += dir;
					map[y][x] = ++value;
				}
				
				N--;
				
				if(N <= 0) break;
				
				for(int i = 0; i < N; i++) {
					y += dir;
					map[y][x] = ++value;
				}
				
				dir *= -1;
				
			} // end while
			System.out.println("#" + test_case);
			print(map);
			
		} // end test case for loop
	} // end main 
	
	public static void print(int[][] map) {
		int N = map.length;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	} // end print func
	
}
