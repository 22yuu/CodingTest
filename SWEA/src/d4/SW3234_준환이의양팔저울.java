package d4;

import java.util.*;
import java.io.*;

public class SW3234_준환이의양팔저울 {
	 
	   static int N;
	   static int weights[];
	   static int sel[];
	   static boolean visited[];
	   static boolean visited2[];
	   static int count;
	   static int N_fact;

	   // N! : 순열(순서), 2^N*N! : 부분집합
	   
	   public static void permutation(int idx) {
		   
		   if(idx == N) {
			   // 여기가 순열 완성 - 완성된 순열의 값은 sel배열에 저장됨
			   PowerSet(0,0,0);
			   return;
		   }
		   
		   for(int i = 0; i < N; i++) {
			   if(!visited[i]) {
				   visited[i] = true;
				   sel[idx] = weights[i];
				   permutation(idx+1);
				   visited[i] = false;
			   }
		   }
		   
	   }
	   
	   public static void PowerSet(int idx, int left, int right) {
		   
		   if(left < right) return;
		   
		   if(idx == N) {
			   // 부분 집합 완성
//			   System.out.println("왼쪽 합 : " + left);
//			   System.out.println("오른쪽 합 : " + right);System.out.println();
			   if(left >= right) count++;
			   return;
		   }
		   
		   PowerSet(idx+1, left+sel[idx], right);
		   PowerSet(idx+1, left, right+sel[idx]);
	   }
	   
	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      
	      int T = Integer.parseInt(br.readLine());
	      
	      for(int testcase = 1; testcase <= T; testcase++) {
	         
	         N = Integer.parseInt(br.readLine());
	         weights = new int[N];
	         visited = new boolean[N];
	         visited2 = new boolean[N];
	         sel = new int[N];
	         count = 0;
	         
	         st = new StringTokenizer(br.readLine());
	         
	         for(int i = 0; i < N; i++) {
	            weights[i] = Integer.parseInt(st.nextToken());
	         }
	         
	         permutation(0);
	         System.out.println("#"+testcase+" "+count);
	      }
	   }
}
