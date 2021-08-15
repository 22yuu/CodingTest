package gold;

import java.util.*;
import java.io.*;

public class boj17472_다리만들기2_2 {

	public static int N, M;
	public static int cntLand;
	public static int answer;
	public static int map[][];
	public static boolean visited[][];
	public static int parent[];
	public static int dx[] = {-1, 1,  0, 0};
	public static int dy[] = { 0, 0, -1, 1};
	public static List<Edge> list = new ArrayList<Edge>();
	
	// 부모
	public static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	
	public static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if( a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	// 같은 부모인지?
	public static boolean isSameParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		return a == b;
	}
	
	public static class Edge implements Comparable<Edge>{
		int node, parent, weight;
		
		public Edge(int node, int parent, int weight) {
			this.node = node;
			this.parent = parent;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	
	
	
	public static void dfs(int x, int y, int num) {
	      
	      visited[x][y] = true;
	      
	      if(map[x][y] == 1) map[x][y] = num; 
	      
	      for(int d = 0; d < 4; d++) {
	         int nx = x + dx[d];
	         int ny = y + dy[d];
	         
	         if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[x][y] == 0) continue;
	         
	         if(visited[nx][ny]) continue;
	         
	         visited[nx][ny] = true;
	         
	         dfs(nx, ny, num);
	      }
	   }
	
	public static void bridge(int x, int y) {
		
		int	me = map[x][y];

		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if(map[nx][ny] == me) continue;
			
			search(nx, ny, d);
			
		}
	}
	
	public static void search(int x, int y, int d) {
		
		int length = 1;
		int node = map[x - dx[d]][y - dy[d]];
		int nx = x;
		int ny = y;
		
		while(true) {
			nx = nx + dx[d];
			ny = ny + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
			 
			if(map[nx][ny] == node) { // ㄷ자 모양처럼 자기 자신을 또 만난다면?
				break;
			}
			
			if(map[nx][ny] >= 1) {
				if(length >= 2) {
					//System.out.println("map["+nx+"]["+ny+"] = " + map[nx][ny] + " node["+ (x - dx[d]) + ", "+ (y - dy[d]) + "] = " + node);
					list.add(new Edge(node, map[nx][ny],length));
					break;
				} else {
					break;
				}
			}
			length++;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      
	      N = Integer.parseInt(st.nextToken());
	      M = Integer.parseInt(st.nextToken());
	      
	      map = new int[N][M];
	      visited = new boolean[N][M];
	      
	      cntLand = 0;
	      
	      // 입력
	      for(int i = 0 ; i < N ; i++) {
	         st = new StringTokenizer(br.readLine());
	         for(int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	         }
	      }
	      
	      // 섬의 개수 카운팅 및 넘버링
	      for(int i = 0 ; i < N ; i++) {
	         for(int j = 0; j < M; j++) {
	            if(!visited[i][j] && map[i][j] == 1) {
	               dfs(i, j, cntLand+1);
	               cntLand++;
	            }
	         }
	      }
		
//		map 프린트
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	     
	    for(int i = 0; i < N; i++) {
	    	for(int j = 0; j < M; j++) {
	    		if(map[i][j] != 0) {
	    			bridge(i,j);
	    		}
	    	}
	    }
	      
	      
		// parent 배열 초기화
		parent = new int[cntLand + 1];
		for(int i = 1; i <= cntLand; i++) parent[i] = i;
		
		Collections.sort(list);
	      
	      // 리스트 확인
//	      for(Edge e : list) {
//	         System.out.println(e.node + " " + e.parent + " " + e.weight);
//	      }
	      
	      for(int i = 0; i < list.size(); i++) {
	         Edge edge = list.get(i);
	         if(!isSameParent(edge.node, edge.parent)) {
	            answer += edge.weight;
	            union(edge.node, edge.parent);
	         }
	      }
	      
	      // 만약 하나의 땅이라도 연결이 안되어있다면?
	      for(int i = 2; i < cntLand; i++) {
	    	  if(!isSameParent(1, i)) {
	    		  answer = -1;
	    		  break;
	    	  }
	      }
	      
	      System.out.println(answer <= 0 ? "-1" : answer);
	}
}
