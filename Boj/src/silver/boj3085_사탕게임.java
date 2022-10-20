package silver;

import java.util.*;
import java.io.*;

public class boj3085_사탕게임 {

	private static int N;
	private static int[][] map;
	private static int MAX = Integer.MIN_VALUE;

	
	
	public static void dfs(int x, int y, int value, int cnt) {
		
	
		if(x < 0 || y < 0 || x >= N || y >= N) return;
		
		if(value != map[x][y]) return;
		else cnt += 1;
		
		dfs(x - 1, y, value, cnt);
		System.out.println(cnt);
		dfs(x + 1, y, value, cnt);
		MAX = Math.max(MAX, cnt);
		cnt = 0;
		dfs(x, y - 1, value, cnt);
		dfs(x, y + 1, value, cnt);
		MAX = Math.max(MAX, cnt);
		
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 빨간색은 C(0), 파란색은 P(1), 초록색은 Z(2), 노란색은 Y(3)
		// init map array
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				char ch = str.charAt(j);
				
				if(ch == 'C') {
					map[i][j] = 0;
				} else if(ch == 'P') {
					map[i][j] = 1;
				} else if(ch == 'Z') {
					map[i][j] = 2;
				} else {
					map[i][j] = 3;
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				// 인접한 두칸 교환 
				swap(i,j, i, j-1);
				dfs(i, j, map[i][j], 1);
				
				// 원위치 
				swap(i,j-1, i, j);
			}
		}
		
		
		System.out.println(MAX);
		

	}
	
	public static void swap(int i1, int j1, int i2, int j2) {
		
		int temp = map[i1][j1];
		map[i1][j1] = map[i2][j2];
		map[i2][j2] = temp;
	}

}
