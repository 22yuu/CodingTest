package d4;

import java.util.*;
import java.io.*;

public class SW3234_준환이의양팔저울2 {
	 
	   static int N;
	   static int weights[];
	   static int sel[];
	   static boolean visited[];
	   static boolean visited2[];
	   static int count;
	   static int N_fact;

	   public static void permutation(int idx) {
		   
		   if(idx == N) {
			   // 여기가 순열 완성 - 완성된 순열의 값은 sel배열에 저장됨
			   PowerSet(0);
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
	   
	   public static void PowerSet(int idx) {
		   
		   int left = 0;
		   int right = 0;
		   int leftIdx = -1;
		   int rightIdx = -1;
		   
//		   int left_arr[] = new int[N];
//		   int right_arr[] = new int[N];
		   
		   if(idx == N) {
			   
//			   System.out.println();
//			   System.out.println("왼쪽");
//			   for(int i = 0; i <N; i++) {
//				   if(visited2[i]) System.out.print(sel[i] + " ");
//			   }
//			   
//			   System.out.println();
//			   System.out.println("오른쪽");
//			   for(int i =0; i <N; i++) {
//				   if(!visited2[i]) System.out.print(sel[i] + " ");
//			   }
			   
			   for(int i = 0; i <N; i++) {
				   if(visited2[i]) {
					   left = sel[i];
					   leftIdx = i;
				   } else {
					   right = sel[i];
					   rightIdx = i;
				   }
				   
				   if( leftIdx == 0 && rightIdx == 0 && left < right) { // 
					   return;
				   } else {
					   left += sel[i];
					   right += sel[i];
				   }
				   
//				   if(left < right) {
//					   return;
//				   }
			   }
			   
			   if(left >= right) count++;
			   return;
		   }
		   
		   visited2[idx] = true;
		   PowerSet(idx+1);
		   visited2[idx] = false;
		   PowerSet(idx+1);
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
	         System.out.println(count);
	      }
	   }
}
