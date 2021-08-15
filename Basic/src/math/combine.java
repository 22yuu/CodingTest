package math;

import java.util.Scanner;

public class combine {
   static int N, R;
   static int sel[];   // 담아놓을 공간
   static boolean visited[];
   
   // 순열은 재귀!
   static void nCr(int idx, int start) {
      if(idx == R) { // 내가 원하는 값의 개수!
         for(int i : sel)
            System.out.print(i + " ");
         System.out.println();
         return;
      }
      
      for (int i = start; i < N; i++) {   // 1 depth  i = 0 2depth i = 1부터 시작
         sel[idx] = i + 1;
         nCr(idx + 1, i + 1);
      } 
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      R = sc.nextInt();
      
      sel = new int[R];
      visited = new boolean[N];
      nCr(0, 0);
      System.out.println();
   }
}