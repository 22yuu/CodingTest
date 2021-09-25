package lv2;

import java.util.*;
import java.io.*;

public class 프렌즈블록 {

	public static int dx[] = {1, 0, 1};
    public static int dy[] = {0, 1, 1}; // 오른쪽, 아래, 오른쪽 대각
    public static int N,M;
    public static char[][] map;
    public static boolean[][] visited;
    public static ArrayList<Point> blocks = new ArrayList<>();
    
    public static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int x, int y) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));
        
        while(!que.isEmpty()) {
            
            Point np = que.poll();
            char ch = map[np.x][np.y];
            int count = 1;
            
            if(np.x == M && np.y == N) {
                print();
                return;
            }
            
            for(int d = 0; d < 3; d++) {
                int nx = np.x + dx[d];
                int ny = np.y + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                
                if(ch == map[nx][ny] && ch != '0') {
                    count++;
                    //System.out.println("count : " + count);
                    //System.out.println("map[" + nx + "][" + ny + "] :" + map[nx][ny]);
                    
                    if(count == 4) {
                        blocks.add(new Point(np.x, np.y));
                        //System.out.println(np.x + ", " + np.y);
                    }
                }
                
                que.offer(new Point(nx, ny));
            }
        }
    }
        
    public static int solution(int m, int n, String[] board) {
    	 int answer = 0;
         M = m;
         N = n;
         
         map = new char[M][N];
         
         for(int i = 0; i < M; i++) {    
             map[i] = board[i].toCharArray();
         }
         
//         while(true) {
//             visited = new boolean[M][N];
//             bfs(0,0);
//             
//             if(blocks.size() > 0) {
//                 answer += getScore();
//             } else {
//                 return answer;
//             }
//             blocks.clear();
//             reBuild();
//             print();
//             
//         }
         
         visited = new boolean[M][N];
         bfs(0,0);
         
         if(blocks.size() > 0) {
             answer += getScore();
         }
         blocks.clear();
         System.out.println("blocks size " + blocks.size());
         reBuild();
         print();
         
         visited = new boolean[M][N];
         bfs(0,0);
         
         if(blocks.size() > 0) {
             answer += getScore();
         }
         System.out.println("blocks size " + blocks.size());
         if(blocks.size() > 0) {
        	 Point np = blocks.get(0);
        	 
        	 System.out.println(np.x + ", " + np.y);
         }
         blocks.clear();
         reBuild();
         print();
         return answer;
    }
    
    public static int getScore() {
        int size = blocks.size();
        int score = 0;
        System.out.println("blocks list size : " + size);
        
        for(int i = 0; i < size; i++) {
            Point np = blocks.get(i);

            if(map[np.x][np.y] != '0') {
                map[np.x][np.y] = '0';
                score++;
            }
            
            for(int d = 0; d < 3; d++) {
                int nx = np.x + dx[d];
                int ny = np.y + dy[d];
                
                if(map[nx][ny] != '0') {
                    map[nx][ny] = '0';
                    score++;
                } else {
                    continue;
                }
            }
        }
        
        return score;
    }
    
    public static void reBuild() {
        // 빈 공간을 채우는 함수
        
        while(true) {
        	int count = 0;
        	for(int j = 0; j < N; j++) {
                for(int i = 0; i < M-1; i++) {
                	
                	if(map[i][j] == '0') continue;
                	
                	//System.out.println(map[i][j]);
                	
                    if(map[i+1][j] == '0') {
                        map[i+1][j] = map[i][j];
                        map[i][j] = '0';
                        count++;
                    }
                }
            }
        	
        	if(count == 0) return;
        }
    }
    
    public static void print() {
        for(int i = 0; i < M; i++) {    
            for(int j = 0; j < N; j++) {    
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
    	String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    	String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
    	
    	System.out.println(solution(4, 5, board));
    	System.out.println(solution(6, 6, board2));
	}
}
