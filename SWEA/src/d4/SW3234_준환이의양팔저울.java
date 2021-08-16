package d4;

import java.util.*;
import java.io.*;

public class SW3234_��ȯ���Ǿ������� {
	 
	   static int N;
	   static int weights[];
	   static int sel[];
	   static boolean visited[];
	   static boolean visited2[];
	   static int count;
	   static int N_fact;

	   // N! : ����(����), 2^N*N! : �κ�����
	   
	   public static void permutation(int idx) {
		   
		   if(idx == N) {
			   // ���Ⱑ ���� �ϼ� - �ϼ��� ������ ���� sel�迭�� �����
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
			   // �κ� ���� �ϼ�
//			   System.out.println("���� �� : " + left);
//			   System.out.println("������ �� : " + right);System.out.println();
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
