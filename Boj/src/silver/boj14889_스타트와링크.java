package silver;

import java.util.*;
import java.io.*;

public class boj14889_스타트와링크 {

	private static int N;
	private static int[][] map;
	private static List<Integer> list = new ArrayList<>();
	private static int[] teamA, teamB;
	private static boolean[] visited;
	
	public static void recu(int idx) {
		
		if(idx == N/2) {
			System.out.print("Team A : ");
			for(int a : teamA) System.out.print(a + " ");
			System.out.println();
			System.out.print("Team B : ");
			for(int a : teamB) System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				teamA[idx] = i+1;
				recu(idx+1);
				visited[i] = false;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				teamB[idx] = i+1;
				recu(idx+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int nTeams = N / 2;
		
		map = new int[N][N];
		teamA = new int[nTeams];
		teamB = new int[nTeams];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recu(0);
		
		
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				if(i == j) continue;
//				int sum = map[i][j] + map[j][i];
//				list.add(sum);
//			}
//		}
		
		
//		Collections.sort(list);
//		System.out.println(list);
//		System.out.println(list.get(1) - list.get(0));
		

	}

}
