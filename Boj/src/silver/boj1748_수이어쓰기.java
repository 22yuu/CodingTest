package silver;

import java.io.*;
import java.util.*;

public class boj1748_수이어쓰기 {

	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		int len = (int)Math.log10(N) + 1; // 자리수
		int a = 9; // 1~9는 9개
		int answer = 9;
		
		if(N < 10) {
			System.out.println(N);
			return;
		}
		
		for(int i = 1; i < len - 1; i++) {
			a = a * 10;
			
			answer += (a * (i+1));
//			System.out.println("current a value : " + a + " / " + "current answer : " + answer);
		}
		
		answer += ((N - (int)(Math.pow(10, len-1)))+1) * len;
		System.out.println(answer);
	}

}
