package gold;

import java.util.*;
import java.io.*;

public class boj17136_색종이붙이기 {

	private final static int SIZE = 10;
	public static int map[][];
	public static int paper[] = {0, 5, 5, 5, 5, 5};
	public static int answer = Integer.MAX_VALUE;

	
	// 백트랙킹
	public static void dfs(int x, int y, int cnt) {
		
		if(x >= SIZE-1 && y > SIZE-1) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		if(answer <= cnt) {
			return;
		}
		
		if(y > SIZE-1) {
			dfs(x+1, 0, cnt);// 다음줄 
			return;
		}
		
		if(map[x][y] == 1) {
			for(int i = 5; i >= 1; i--) { // 큰 색종이 먼저 붙이면서 탐색
				if(paper[i] > 0 && isAvailable(x, y, i)) {
					action(x, y, i, 0);
					paper[i]--; // 색종이 최대 5개까지 붙이기 가능
					dfs(x, y+1, cnt+1);
					action(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}
	
	// 색종이를 붙이거나 뗀다. state 값이 0 : 붙임, 1 : 뗀다.
	public static void action(int x, int y, int size, int state) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	
	public static boolean isAvailable(int x, int y, int size) {
		
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(i < 0 || i >= SIZE || j < 0 || j >= SIZE) {
					return false;
				}
				
				if(map[i][j] == 0) return false;
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);
		
	}
}
 