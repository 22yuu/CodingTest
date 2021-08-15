package math;

import java.util.*;
import java.io.*;

public class 에라토스테네스의체 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * 소수를 구할때 주로 쓰는 방법인 에라토스테네스의 체이다.
		 * 이 프로그램의 입력 방법은 두 수 M, N이 주어지면
		 * 두 수 사이의 범위에서 소수를 찾아주는 프로그램이다.
		 * 두 수는 띄어쓰기로 구분한다.
		 * 예)3 16
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[M+1];
		prime[0]=prime[1]=true;
		
		for(int i =2; i*i <=M; i++) {
			
			// 소수라면
			if(!prime[i]) {
				for(int j=i*i; j <=M; j+=i) prime[j] = true;
			}
		}
		
		// 소수 출력
		for(int i = N; i <= M; i++) {
			if(!prime[i]) System.out.println(i);
		}
	}
}
