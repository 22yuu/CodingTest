package gold;

import java.util.*;
import java.io.*;

public class boj14499_林荤困奔府扁 {
	
	private static int N, M;
	private static List<Integer> orders;
	private static int[][] board;
	private static int[] dx = {0, 0, 0,-1, 1};
	private static int[] dy = {0, 1,-1, 0, 0};
	
	
	public static class Dice {
		int x, y;
		int front = 0, behind = 0, top = 0, bottom = 0, left = 0, right = 0;
		
		public Dice(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = 0, y = 0, k = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Dice dice = new Dice(x,y);
		
		board = new int[N][M];
		orders = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) orders.add(Integer.parseInt(st.nextToken()));
		
//		System.out.println(orders.toString());
		
		for(int i = 0; i < orders.size(); i++) {
			int d = orders.get(i);
			
			int nx = dice.x + dx[d];
			int ny = dice.y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			boolean flag = board[nx][ny] > 0;
			
			int temp;
			
			switch(d) {
				case 1:
					// 悼率
					temp = dice.bottom;
					dice.bottom = dice.right;
					dice.right = dice.top;
					dice.top = dice.left;
					dice.left = temp;
					break;
				case 2:
					// 辑率
					temp = dice.bottom;
					dice.bottom = dice.left;
					dice.left = dice.top;
					dice.top = dice.right;
					dice.right = temp;
					break;
				case 3:
					// 合率
					temp = dice.bottom;
					dice.bottom = dice.behind;
					dice.behind = dice.top;
					dice.top = dice.front;
					dice.front = temp;
					break;
				case 4:
					// 巢率
					temp = dice.bottom;
					dice.bottom = dice.front;
					dice.front = dice.top;
					dice.top = dice.behind;
					dice.behind = temp;
					break;
			}
			
			if(flag) {
				dice.bottom = board[nx][ny];
				board[nx][ny] = 0;
			} else {
				board[nx][ny] = dice.bottom;
			}
			
			dice.x = nx;
			dice.y = ny;
			
			System.out.println(dice.top);
		}
		
		
		
		
	}
}
