package math;

import java.util.Scanner;

public class permutation2 {
   static int N;
   static int sel[];   // 담아놓을 공간
   static boolean visited[];
   // 순열은 재귀!
   static void nPn(int idx) {
      if(idx == N) {
         for(int i : sel)
            System.out.print(i + " ");
         System.out.println();
         return;
      }
      
      for (int i = 0; i < N; i++) {
         if(!visited[i]) {
            visited[i] = true;
            sel[idx] = i + 1;
            nPn(idx + 1);
            visited[i] = false;
         }
      }
   }
   
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      sel = new int[N];
      visited = new boolean[N];
      nPn(0);
      System.out.println();
   }
}