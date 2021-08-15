package d4;

import java.util.*;
import java.io.*;

public class SW1211_Ladder2 {
	
	public static int size = 100;
	public static int map[][];
	public static int map2[][];
	
	public static boolean visited[][];
	public static int dr[] = { 1,  0, 0};
	public static int dc[] = { 0, -1, 1}; // ¾Æ·¡, ¿Þ, ¿À : 0 1 2
	public static List<Integer> list;
	
	public static class Point {
		int r, c, value;
		
		public Point(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}
	
	public static void dfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r,c, 1));
		visited[r][c] = true;
		int value = 1;
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			
			if(np.r == (size-1)) {
				list.add(np.value);
			}
			
			for(int d = 0; d < 3; d++) {
				
				int nr = np.r + dr[d];
				int nc = np.c + dc[d];
				
				if(nr < 0 || nr >= size || nc < 0 || nc >= size || map[nr][nc] == 0) continue;
				
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				value += 1;
				//System.out.print(value + " ");
				map2[nr][nc] = map2[np.r][np.c]+1;
				que.offer(new Point(nr, nc, value));
				//break;
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int testcase = 1; testcase <= 10; testcase++) {
			map = new int[size][size];
			map2 = new int[size][size];
			
			visited = new boolean[size][size];
			list = new ArrayList<>();
			
			int T = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[i][j] = map[i][j];
				}
			}
			dfs(0,0);
//			int count = 0;
//			for(int i = 0; i < size; i++) {
//				if(map[0][i] == 1) {
//					dfs(0, i);
//					System.out.println("times : " + (count+1));
//				}
//			}
//			
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print(map2[i][j] + "   ");
				}
				System.out.println();
			}
			
//			Collections.sort(list);
			System.out.println(list.toString());
			//System.out.println("#" + testcase + " " + list.get(0));
		}
	}
}