package gold;

import java.util.*;
import java.io.*;

public class boj14503_·Îº¿Ã»¼Ò±â2 {
	
	private static int N, M;
	private static int[][] map;
	private static int dx[] = {0, -1, 0, 1}; // ºÏ, ¼­, ³², µ¿
	private static int dy[] = {-1, 0, 1, 0}; // ºÏ, ¼­, ³², µ¿
	private static int count = 0;
	
	
	private static void check(int r, int c, int dir) {
		int nr = r;
		int nc = c;
		
		while(true) {
			
			nr = r + dx[dir];
			nc = c + dy[dir];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
			
			if(map[nr][nc] == 1) break;
			
			if(map[nr][nc] != -1) {
				map[nr][nc] = -1;
				count += 1;
				check(nr, nc, dir);
			}
		}
	}
	
	private static void robot(int x, int y) {
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		
		inputs = br.readLine().split(" ");
		
		int r = Integer.parseInt(inputs[0]);
		int c = Integer.parseInt(inputs[1]);
		int dir = Integer.parseInt(inputs[2]);
		
		for(int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		map[r][c] = -1;
		
		
		
		
		
	}
}
