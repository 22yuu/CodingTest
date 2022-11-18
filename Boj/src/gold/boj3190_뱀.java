package gold;

import java.util.*;
import java.io.*;




public class boj3190_¹ì {
	
	private static int N, K, L;
	private static int[][] board;
	private static int snakeLength = 0;
	private static int[] tailCoord;
	private static int[] dx = {0, -1};
	private static int[] dy = { 1, 0};
	private static List<Direction> direction_list;
	
	public static class Direction {
		int sec;
		char dir;
		
		Direction(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		tailCoord = new int[] {1,1};
		
		board[1][1] = -1;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[r][c] = 1;
		}
		
		direction_list = new ArrayList<>();
		
		L = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			direction_list.add(new Direction(X, C));
		}
		
		int nr = 1;
		int nc = 1;
		int time = 0;
		int listIdx = 0;
		int currentDir = 0; // 0, 1, 2, 3 -> c++, r++, c--, r--
		
		Loop : while(true) {
			time++;
			
			switch(currentDir) {
				case 0:
					nc = nc + 1;
					if(nc > N - 1 || isEnd(board[nr][nc], nc)) break Loop;
					
					if(board[nr][nc] == 0) {
						setTailCoord(nr, nc);
					}
					
					board[nr][nc] = -1;
					break;
				case 1:
					nr = nr + 1;
					if(nr > N - 1 || isEnd(board[nr][nc], nr)) break Loop;
					
					if(board[nr][nc] == 0) {
						setTailCoord(nr, nc);
					}
					
					board[nr][nc] = -1;
					
					break;
				case 2:
					nc = nc - 1;
					if(nc < 0 || isEnd(board[nr][nc], nc)) break Loop;
					
					if(board[nr][nc] == 0) {
						setTailCoord(nr, nc);
					}
					
					board[nr][nc] = -1;
					
					break;
				case 3:
					nr = nr - 1;
					if(nr < 0 || isEnd(board[nr][nc], nr)) break Loop;
					
					if(board[nr][nc] == 0) {
						setTailCoord(nr, nc);
					}
					
					board[nr][nc] = -1;
					break;
			}
			
//			System.out.println((listIdx < L) + " " + listIdx + " " + L + "size : " + direction_list.size());
			if(listIdx <= L-1 && time == direction_list.get(listIdx).sec) {
				char dir = direction_list.get(listIdx).dir;
				
				switch(dir) {
					case 'D':
						// ¿À¸¥ÂÊ 90deg
						if(currentDir == 0) {
							currentDir = 1;
						} else if (currentDir == 1) {
							currentDir = 0;
						} else if(currentDir == 2) {
							currentDir = 3;
						} else if(currentDir == 3) {
							currentDir = 1;
						}
						
						break;
					case 'L':
						// ¿ÞÂÊ 90 deg
						if(currentDir == 0) {
							currentDir = 3;
						} else if (currentDir == 1) {
							currentDir = 2;
						} else if(currentDir == 2) {
							currentDir = 1;
						} else if(currentDir == 3) {
							currentDir = 0;
						}
						break;
				}
				
				listIdx++;
			}
			
			
			
			
			System.out.println("current time is " + time);
			System.out.println("============");
//			System.out.println("change next direction value is : " + direction_list.get(listIdx).sec + ", " + direction_list.get(listIdx).dir + ", list index  : " + listIdx);
			print();
		}
		
		
		System.out.println(time);
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void setTailCoord(int nr, int nc) {
		board[tailCoord[0]][tailCoord[1]] = 0;
		 tailCoord[0] = nr;
		 tailCoord[1] = nc;
	}
	
	public static boolean isEnd(int value, int nextField) {
		
		if(nextField == -1) return true;
		return false;
	}
}
