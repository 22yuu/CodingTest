package silver;

import java.util.*;
import java.io.*;


public class boj2583_영역구하기 {
	
	private static int M, N, K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static List<Integer> list;
	
	static class Pointer {
		int x, y;
		
		Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int i, int j) {
		Queue<Pointer> que = new LinkedList<>();
		que.offer(new Pointer(i, j));
		visited[i][j] = true;
		int count = 1;
		
		while(!que.isEmpty()) {
			Pointer np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
				
				if(map[nx][ny] == 1) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				que.offer(new Pointer(nx, ny));
				count++;
			}
		}
		
		
		return count;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		M = Integer.parseInt(inputs[0]);
		N = Integer.parseInt(inputs[1]);
		K = Integer.parseInt(inputs[2]);
		
		map = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<>(); // 영역 탐색 결과를 저장할 List
		
		for(int i = 0; i < K; i++) {
			inputs = br.readLine().split(" ");
			int x1 = Integer.parseInt(inputs[0]);
			int y1 = Integer.parseInt(inputs[1]);
			int x2 = Integer.parseInt(inputs[2]);
			int y2 = Integer.parseInt(inputs[3]);
			
			for(int y = y1; y < y2; y++) {
				
				for(int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		int count = 0; // 영역을 셀 변수
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					count++;
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(count);
		for(Integer n: list) System.out.print(n + " ");
//		print();
	}
	
	public static void print() {
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
