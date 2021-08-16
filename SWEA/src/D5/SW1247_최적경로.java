package D5;

import java.util.*;
import java.io.*;

public class SW1247_최적경로 {

	public static int kakako[]; // 내가 다니는 회사 카카오 ㅎ
	public static int sweetHome[]; // 스윗홈
	public static int N; // 닝겐수
	public static int map[][];
	public static int sel[];
	public static boolean visited[];
	public static int min;
	public static List<Integer> list;
	
	public static void work(int idx, int x, int y, int dist) {
		
		if(idx == N+1) {
			//int sum = 0;
//			for(int i = 0; i < N+1; i++) {
//				sum += Math.abs(map[sel[i]][0] - map[sel[i+1]][0]) +  Math.abs(map[sel[i]][1] - map[sel[i+1]][1]);
//			}
			if(min > dist) {
				min = dist;
			}
			return;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int d = Math.abs(map[i][0] - x) + Math.abs(map[i][1] - y);
				sel[idx] = i;
				work(idx+1, map[i][0], map[i][1], dist+d);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][2];
			visited = new boolean[N+2];
			list = new ArrayList<Integer>();
			min = Integer.MAX_VALUE;
			
			sel = new int[N+2];
			
			st = new StringTokenizer(br.readLine());
			int temp[][] = new int[N+2][2];
			
			for(int i = 0; i < N+2; i++) {
				temp[i][0] = Integer.parseInt(st.nextToken());
				temp[i][1] = Integer.parseInt(st.nextToken());
			}
			
			map[0] = temp[0]; // 시작
			map[N+1] = temp[1]; // 끝
			sel[0] = 0;
			sel[N+1] = N+1;
			
			for(int i = 1; i < N+1; i++ ) map[i] = temp[i+1];
			
			visited[0] = true;
			work(1, map[0][0], map[0][1], 0);
			
			System.out.println("#" + testcase + " " + min);
		}
	}
}
