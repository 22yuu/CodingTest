package DP;

import java.util.*;
import java.io.*;

/*
 * 
 * 
 */
public class DP_개미전사 {
	
	public static int[] d = new int[100];
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int store[] = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < num; i++) {
			store[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = store[0];
		d[1] = Math.max(store[0], store[1]);
		for(int i = 2; i < num; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + store[i]);
		}
		
		System.out.println(d[num-1]);
	}
}
