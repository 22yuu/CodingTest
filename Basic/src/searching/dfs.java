package searching;

import java.util.Scanner;

public class dfs {
   static int N, map[][];
   static boolean visited[][];
   // 2차원 배열의 탐색 시작0,
   static int dr[] = { -1, 1, 0, 0 };// 상 하 좌 우 4방탐색
   static int dc[] = { 0, 0, -1, 1 };

   static void print(int map[][]) {
      for (int i = 0; i < map.length; i++) {
         for (int j = 0; j < map[0].length; j++) {
            System.out.print(map[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();
   }

   // 0, 0 에서 시작해서 어디까지 간다고? N-1, N-1까지 갈꺼야
   // DFS 깊이 우선 탐색으로 풀어볼꺼야

   static void dfsFunc(int r, int c, int cnt) {
      if (r == N - 1 && c == N - 1) {
         print(map);
         return;
      }

      for (int d = 0; d < 4; d++) {
         int nr = r + dr[d];
         int nc = c + dc[d];

         // 탐색에서는 조건체크를 잘해야해됨
         // 배열을 빠져 나갔는가?
         // ArrayIndexOutOfBound
         if (nr < 0 || nc < 0 || nr >= N || nc >= N)
            continue;
         
         if(visited[nr][nc])
            continue;
         // 갈 수 있다는거
         
         map[nr][nc] = cnt + 1;
         visited[nr][nc] = true;
         dfsFunc(nr, nc, cnt + 1);
         map[nr][nc] = 0;
         visited[nr][nc] = false;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      map = new int[N][N];
      visited = new boolean[N][N];
      map[0][0] = 1;
      visited[0][0] = true;
      dfsFunc(0, 0, 1);
      // 0 0 0
      // 0 0 0
      // 0 0 0
      System.out.println();
   }
}