package gold;

import java.util.*;
import java.io.*;

public class boj2636_치즈2 {
	
	private static int H, W; // 세로와 가로길이
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	
	private static class Pointer {
		int x, y;
		
		Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<Pointer> que = new LinkedList<>();
		que.offer(new Pointer(x,y));
		visited[x][y] = true;
		int count = 0;
		
		
		while(!que.isEmpty()) {
			Pointer np = que.poll();
			if(np.x == H - 1 && np.y == W - 1) {
				return count;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				
				if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					visited[nx][ny] = true;
					count++;
					continue;
				}
				
				visited[nx][ny] = true;
				que.offer(new Pointer(nx, ny));
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		
		H = Integer.parseInt(inputs[0]);
		W = Integer.parseInt(inputs[1]);
		
		map = new int[H][W];
		visited = new boolean[H][W];
		
		for(int i = 0; i < H; i++) {
			inputs = br.readLine().split(" ");
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		
		int hours = 0;
		int count = 0;
		List<Integer> list = new ArrayList<>();
		while(true) {
			count = bfs(0,0);
			list.add(count);
			if(count == 0) break;
			visited = new boolean[H][W];
			hours++;
		}
		
//		System.out.print(hours + " " + list.get(hours - 1));
		System.out.println(hours);
		System.out.println(hours == 0 ? 0 : list.get(hours - 1));
	}
	
	public static void print() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
