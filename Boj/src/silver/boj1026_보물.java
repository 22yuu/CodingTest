package silver;

import java.util.*;
import java.io.*;

public class boj1026_º¸¹° {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strA = br.readLine().split(" ");
		String[] strB = br.readLine().split(" ");
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i = 0; i < strA.length; i++) {
			A[i] = Integer.parseInt(strA[i]);
			B[i] = Integer.parseInt(strB[i]);
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		int idx = A.length - 1;
		
		for(int i = 0; i < A.length; i++) {
			sum += A[i] * B[idx - i];
//			System.out.println(A[i] + " * " + B[idx - i]);
		}
		
		System.out.println(sum);
		

	}

}
