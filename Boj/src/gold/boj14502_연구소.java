package gold;

import java.util.*;
import java.io.*;

public class boj14502_������ {
	
	private static int N, M;
	private static int STICKS = 3;
	private static int[][] map;
	private static List<Position> list;
	
	private static int[] dx = { 0, 0, -1, 1}; // �¿� ���� �޾Ʒ��밢 ���Ʒ��밢
	private static int[] dy = {-1, 1,  0, 0}; // �¿� ���� �޾Ʒ��밢 ���Ʒ��밢
	
	public static class Position {
		int x, y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void dfs(int x, int y) {
		
		int count = 0;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			count++;
			list.add(new Position(nx, ny));
			
			
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					dfs(i, j);
				}
			}
		}
		
		
	}
}
