package silver;

import java.util.*;
import java.io.*;

public class boj18290_NM과K {

	private static int N, M, K;
	private static Coord sel[];
	private static int[][] map;
	private static boolean[][] selected;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int answer = Integer.MIN_VALUE;
	
	
	private static class Coord {
		int x, y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static boolean isSelected(int x, int y) {
		
		
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx > N -1 || ny > M - 1 || nx < 0 || ny < 0) continue;
			
			if(selected[nx][ny]) {
				// 현재 좌표 인접에 선택한 값이 있음 
				return true;
			}
		}
		
		return false;
	}
	
	public static void func(int idx) {
		
		// 서로 인접하지 않은 K개 숫자를 선택
		
		if(idx == K-1) {
			int sum = 0;
			for(Coord coord : sel) {
				sum += map[coord.x][coord.y];
			}
			
			answer = Math.max(answer, sum);
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				// 주변 4방향 체크
				if(isSelected(i,j)) continue;
				
				// 인전합 곳에 선택된 값이 없고 현재 값이 선택되지 않은 값이라면 선택!
				if(!selected[i][j]) {
					
					selected[i][j] = true;
					sel[idx] = new Coord(i, j);
					func(idx+1);
					selected[i][j] = false;
					
				} // end if
				
			}
		} // end for
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		selected = new boolean[N][M];
		sel = new Coord[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0);
		
		System.out.println(answer);
	}

}
