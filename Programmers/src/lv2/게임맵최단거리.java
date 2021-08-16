package lv2;

import java.util.*;

public class 게임맵최단거리 {

	static class Solution {
	    int dx[] = {1,-1,0,0};
	    int dy[] = {0, 0,1,-1};
	    int n, m, result;
	    int map[][];
	    boolean visited[][];
	    
	    
	    public int bfs(int x, int y) {
	        Queue<Point> que = new LinkedList<>();
	        que.offer(new Point(x,y,1));
	        visited[x][y] = true;
	        
	        while(!que.isEmpty()) {
	            Point np = que.poll();
	            
	            if(np.x == n-1 && np.y == m-1) return np.dist;
	            
	            for(int d = 0; d < 4; d++) {
	                int nx = np.x + dx[d];
	                int ny = np.y + dy[d];
	                
	                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
	                if(visited[nx][ny] || map[nx][ny] == 0) continue;
	                
	                visited[nx][ny] = true; 
	                que.offer(new Point(nx, ny, np.dist + 1));
	            }
	        }
	        return -1;
	    }
	    
	    public int solution(int[][] maps) {
	        int answer = 0;
	        n = maps[0].length;
	        m = maps.length;
	        
	        map = maps;
	        visited = new boolean[n][m];
	        
	        answer = bfs(0, 0); 
	        
	        return answer;
	    }
	    
	    public class Point {
	        int x, y, dist;
	        
	        public Point(int x, int y, int dist) {
	            this.x = x;
	            this.y = y;
	            this.dist = dist;
	        }
	    }
	}
	
	public static void main(String[] args) {
		int maps[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		Solution sol = new Solution();
		
		
		System.out.println(sol.solution(maps));
	}
}
