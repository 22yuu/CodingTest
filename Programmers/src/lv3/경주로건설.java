package lv3;

import java.util.*;


public class 경주로건설 {

	static class Solution {
	    
	    public int map[][];
	    public boolean visited[][];
	    public int dx[] = {-1, 1,  0, 0};
	    public int dy[] = { 0, 0, -1, 1}; // 상하좌우
	    public int N;
	    public int min = Integer.MAX_VALUE;
	    
	    public class Road {
	        int x, y, direction, cost;
	        public Road(int x, int y, int direction, int cost) {
	            this.x = x;
	            this.y = y;
	            this.direction = direction;
	            this.cost = cost;
	        }
	    }
	    
	    public void bfs(int x, int y, int dir, int cost) {
	        Queue<Road> que = new LinkedList<>();
	        que.offer(new Road(x,y,dir, cost));
	        visited[x][y] = true;
	        
	        while(!que.isEmpty()) {
	            Road np = que.poll();
	            
	            int direction = np.direction;
	            int weight = np.cost;
	            int qx = np.x;
	            int qy = np.y;
	            
	            if(qx == N-1 && qy == N-1) {
	                min = Math.min(min, weight);
	            }
	            
	            for(int d = 0; d < 4; d++) {
	                
	                int nx = qx + dx[d];
	                int ny = qy + dy[d];
	                int sumCost = weight;
	                
	                if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1) continue;
	                
	                if(direction == -1) {
	                    sumCost += 100;
	                } else if(direction == d) {
	                    sumCost += 100;
	                } else {
	                    sumCost += 600;
	                }
	                
	                if(!visited[nx][ny] || map[nx][ny] >= sumCost) {
	                    visited[nx][ny] = true;
	                    map[nx][ny] = sumCost;
	                    que.offer(new Road(nx, ny, d, sumCost));    
	                }
	            }
	        }
	    }
	    
	    public int solution(int[][] board) {
	        int answer = 0;
	        N = board.length;
	        map = board.clone();
	        visited = new boolean[N][N];
	        bfs(0,0,-1,0);
	        
	        answer = min;
	        
	        return answer;
	    }    
	}
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(board));
		
	}
}
