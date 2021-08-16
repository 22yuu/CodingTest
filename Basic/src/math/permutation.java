package math;

import java.util.Scanner;

public class permutation {
   static int N;
   static int sel[];   // 담아놓을 공간
   // 순열은 재귀!
   static void nPn(int idx) {
      
      if(idx == N) {
         for(int i : sel)
            System.out.print(i + " ");
         System.out.println();
         return;
      }
      
      for (int i = 0; i < N; i++) {
         sel[idx] = i + 1;
         nPn(idx + 1);
      }
   }
   
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      sel = new int[N];
      nPn(0);
      System.out.println();
   }
}