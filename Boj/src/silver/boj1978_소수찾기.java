package silver;

import java.util.*;
import java.io.*;

public class boj1978_소수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i < N; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			if(isPrimNum(num)) cnt++; 
		}
		System.out.println(cnt);
	}
	
	public static boolean isPrimNum(int num) {
		
		if(num == 1) return false;
		
		int cnt = 0;
		for(int i = 2; i < num; i++) {
			if(num % i == 0 ) cnt++;
			
			if(cnt >= 1) return false;
		}
		return true;
	}
}
