package math;

import java.util.Scanner;

public class combine {
   static int N, R;
   static int sel[];   // ��Ƴ��� ����
   static boolean visited[];
   
   // ������ ���!
   static void nCr(int idx, int start) {
      if(idx == R) { // ���� ���ϴ� ���� ����!
         for(int i : sel)
            System.out.print(i + " ");
         System.out.println();
         return;
      }
      
      for (int i = start; i < N; i++) {   // 1 depth  i = 0 2depth i = 1���� ����
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