package gold;

import java.util.*;
import java.io.*;

public class boj17472_다리만들기2 {
	
	   public static int N, M;
	   public static int map[][];
	   public static boolean visited[][];
	   public static int dx[] = {-1, 1,  0, 0};
	   public static int dy[] = { 0, 0, -1, 1};
	   public static int parent[];
	   public static int cntLand;
	   public static int your_parent_node;
	   public static int answer = 0;
	   
	   public static List<Edge> list = new ArrayList<>();
	   
	   // 부모 노드 값 가져오기
	   public static int getParent(int x) {
	      if(parent[x] == x) return x;
	      return parent[x] = getParent(parent[x]);
	   }
	   
	   // 합치기
	   public static void union(int a, int b) {
	      a = parent[a];
	      b = parent[b];
	      
	      if( a < b ) parent[b] = a;
	      else parent[a] = b;
	   }
	   
	   // 같은 부모인지?
	   public static boolean find(int a, int b) {
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
	      //map[x][y] = num;
	      
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
	      
	      int length = 0;
	      // 4방향 탐색
	      for(int d = 0; d < 4; d++) {
	         int nx = x + dx[d];
	         int ny = y + dy[d];
	         
	         if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
	         
	         if(map[nx][ny] == 0) {
	            if(isAvailable(nx, ny, d)) {
	               length = connect(nx,ny,d);
	            }
	         }
	         
	         if(length >= 2) {
	            list.add(new Edge(map[nx][ny], your_parent_node, length));
	         }
	      }
	   }
	   
	   public static boolean isAvailable(int x, int y, int d) {

	      int nx = x;
	      int ny = y;
	      
	      while(true) {
	         nx = nx + dx[d];
	         ny = ny + dy[d];
	         
	         if(nx < 0 || nx >= N || ny < 0 || ny >= M) return false;
	         
	         if(map[nx][ny] >= 1) return true;
	      }
	   }
	   
	   public static int connect(int x, int y, int d) {
	      int nx = x;
	      int ny = y;
	      int count = 0;
	      
	      while(true) {
	         nx = nx + dx[d];
	         ny = ny + dy[d];
	         
	         if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
	         
	         if(map[nx][ny] >= 1) {
	            your_parent_node = map[nx][ny];
	            break;
	         }
	         count++;
	      }
	      return count;
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
	      
	      // 다리 연결 가능 여부 파악 후 다리 연결!!
	      for(int i = 0 ; i < N ; i++) {
	         for(int j = 0; j < M; j++) {
	            if(map[i][j] != 1) {
	               bridge(i, j);
	            }
	         }
	      }
	      //System.out.println(cntLand);
	      
//	      프린트
//	      for(int i = 0 ; i < N ; i++) {
//	         for(int j = 0; j < M; j++) {
//	            System.out.print(map[i][j] + " ");
//	         }
//	         System.out.println();
//	      }
	      
	      // parent 배열 초기화
	      parent = new int[cntLand+1];
	      
	      for(int i = 1; i <= cntLand; i++) parent[i] = i;
	      

	      
	      // list안 중복데이터 제거
	      for(int i = 0; i < list.size(); i++) {
	         Edge edge = list.get(i);
	         for(int j = 1; j < list.size(); j++) {
	            Edge temp = list.get(j);
	            
	            if(edge.node == temp.node && edge.parent == temp.parent && edge.weight == temp.weight) {
	               list.remove(j);
	            }
	         }
	      }
	      
	      // weight 기준으로 오름차순 정렬
	      Collections.sort(list);
	      
	      // 리스트 확인
//	      for(Edge e : list) {
//	         System.out.println(e.node + " " + e.parent + " " + e.weight);
//	      }
	      
	      for(int i = 0; i < list.size(); i++) {
	         Edge edge = list.get(i);
	         if(!find(edge.node, edge.parent)) {
	            answer += edge.weight;
	            union(edge.node, edge.parent);
	         }
	      }
	      
	      // 만약 하나의 땅이라도 연결이 안되어있다면?
	      for(int i = 2; i < cntLand; i++) {
	    	  if(!find(1, i)) {
	    		  answer = -1;
	    		  break;
	    	  }
	      }
	      
//	      System.out.println(answer);
	      System.out.println(answer <= 0 ? "-1" : answer);
	   }
}
