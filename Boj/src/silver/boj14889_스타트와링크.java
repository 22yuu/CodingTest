package silver;

import java.util.*;
import java.io.*;

public class boj14889_스타트와링크 {

	private static int N;
	private static int[][] map;
	private static int answer = Integer.MAX_VALUE;
	private static List<Integer> list = new ArrayList<>();
	private static List<Integer> teamA, teamB;
	private static boolean[] visited;
	
	public static void recu(int start, int idx) {
		
		if(idx == N/2) {
			diff();
			return;
//			teamA = new ArrayList<>();
//			teamB = new ArrayList<>();
//			int sumA = 0;
//			int sumB = 0;
//			
//			/*
//			 * 2개의 팀으로 나누기 위해 방문을 한 사람은 A팀
//			 * 방문을 하지 않은 사람은 B팀으로 편성
//			 * 
//			 * */
//			for(int i = 0; i < N; i++) {
//				if(visited[i]) teamA.add(i);
//				else teamB.add(i);
//			}
//			
//			System.out.println(teamA);
//			System.out.println(teamB);
//			
//			for(int i = 0; i < teamA.size() - 1; i++) {
//				int ax = teamA.get(i);
//				int ay = teamA.get(i+1);
//				int bx = teamB.get(i);
//				int by = teamB.get(i+1);
//				
//				System.out.println("ax : " + ax + " ay : " + ay + " S"+ax+""+ay+" " + map[ax][ay] + " S"+ay+""+ax+" "+map[ay][ax]);
//				System.out.println("bx : " + bx + " by : " + by + " L"+bx+""+by+" " + map[bx][by] + " L"+by+""+bx+" "+map[by][bx]);
//				
//				sumA += map[ax][ay] + map[ay][ax];
//				sumB += map[bx][by] + map[by][bx];
//			}
//			
//			int diff = Math.abs(sumA - sumB);
//			System.out.println("sumA :" + sumA + " sumB : " + sumB + " diff : " + diff);
//			answer = Math.min(answer, diff);
//			
//			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				recu(i+1, idx+1);
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
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recu(0,0);
		
		System.out.println(answer);
	}
	
	static void diff() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] == true && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				else if (visited[i] == false && visited[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(team_start - team_link);
		
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		answer = Math.min(val, answer);
			
	}

}
