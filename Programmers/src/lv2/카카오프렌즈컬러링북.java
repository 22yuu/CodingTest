package lv2;

public class Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ {

    public int M,N;
    public int map[][];
    public boolean visited[][];
    public int dr[] = {-1, 1,  0, 0};
    public int dc[] = { 0, 0, -1, 1};
    public int max;
    
    public void dfs(int r, int c, int count) {

        visited[r][c] = true;
               
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] == 0) continue;
            
            if(visited[nr][nc]) continue;
            
            visited[nr][nc] = true;
            
            dfs(nr, nc, count + 1);
        }
        //System.out.println(count);
        if(count > max) max = count;
        return;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int count = 0;
        
        int[] answer = new int[2];

        M = picture.length;
        N = picture[0].length;
        max = Integer.MIN_VALUE;
        
        map = new int[M][N];
        visited = new boolean[M][N];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = picture[i][j];
            }
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    dfs(i,j, 1);
                    numberOfArea++;
                }
            }
        }
        maxSizeOfOneArea = max;
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}
