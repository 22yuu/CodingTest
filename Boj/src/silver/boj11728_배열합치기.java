package silver;

import java.util.*;
import java.io.*;

public class boj11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arrA[] = new int[n];
		int arrB[] = new int[m];
		int newArr[] = new int[n+m];
		
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < arrA.length; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			list.add(arrA[i]);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arrB.length; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
			list.add(arrB[i]);
		}
		
		
		for(int i = 0; i < n+m; i++) {
			if(i < n ) newArr[i] = arrA[i];
			else newArr[i] = arrB[(m+n) - i - 1];
		}
		
		
		int idxA = 0; int idxB = 0;
		
		while(idxA <= n && idxB <= m) {
			
			if(idxA == n && idxB == m) break;
			
			if(idxA == n) {
				sb.append(arrB[idxB++] + " ");
			} else if(idxB == m) {
				sb.append(arrA[idxA++] + " ");
			} else if(arrA[idxA] < arrB[idxB]) {
				sb.append(arrA[idxA++] + " ");
			} else {
				sb.append(arrB[idxB++] + " ");
			}
		}
		
		System.out.println(sb.toString());
		
//		Arrays.sort(newArr);
//		
//		for(int num : newArr) sb.append(num + " ");
//		System.out.println(sb.toString());
		
		
//		Collections.sort(list);
//		for(int num : list) sb.append(num + " ");
//		System.out.println(sb.toString());

	}

}
