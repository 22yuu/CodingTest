package gold;

import java.util.*;
import java.io.*;


/* 
 * 0은 빈칸, 1은 집, 2는 치킨집
 * 
 */
public class boj15686_치킨배달 {
	
	public static int N, M;
	public static int map[][];
	public static int dx[] = {-1, 1, 0,  0};
	public static int dy[] = { 0, 0, 1, -1};
	public static ArrayList<Coord> homes;
	public static ArrayList<Coord> chickens;
	public static boolean visited[];
	public static int answer;
	public static int minDist = Integer.MAX_VALUE;
	

	public static class Coord {
		int x, y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		
		map = new int[N+1][N+1];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 1) {
					homes.add(new Coord(i, j));
				} else if( num == 2) {
					chickens.add(new Coord(i, j));
				}
			}
		}
		
		visited = new boolean[chickens.size()];
		selectChicken(0, 0);

		System.out.println(minDist);
	}
	
	public static void selectChicken(int idx, int count) {
		if(count == M) {
			int sum = 0;
			int dist = 0;
			int cnt = 0;
			for(Coord home : homes) {
				int min = Integer.MAX_VALUE;
				for(int i = 0; i < visited.length; i++) {
					if(visited[i]) {
						dist = Math.abs(home.x - chickens.get(i).x) + Math.abs(home.y - chickens.get(i).y);
						min = Math.min(min, dist);
//						cnt++;
//						System.out.println("cnt : " + cnt);
					}
				}
				sum += min;
				
			}
			//System.out.println(sum);
			minDist = Math.min(minDist, sum);
			return;
		}
		
		for(int i = idx; i < chickens.size(); i++) {
			visited[i] = true;
			selectChicken(i + 1, count + 1);
			visited[i] = false;
		}
		
		
	}
}
