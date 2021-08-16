package math;

import java.util.*;
import java.io.*;

public class �����佺�׳׽���ü {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * �Ҽ��� ���Ҷ� �ַ� ���� ����� �����佺�׳׽��� ü�̴�.
		 * �� ���α׷��� �Է� ����� �� �� M, N�� �־�����
		 * �� �� ������ �������� �Ҽ��� ã���ִ� ���α׷��̴�.
		 * �� ���� ����� �����Ѵ�.
		 * ��)3 16
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[M+1];
		prime[0]=prime[1]=true;
		
		for(int i =2; i*i <=M; i++) {
			
			// �Ҽ����
			if(!prime[i]) {
				for(int j=i*i; j <=M; j+=i) prime[j] = true;
			}
		}
		
		// �Ҽ� ���
		for(int i = N; i <= M; i++) {
			if(!prime[i]) System.out.println(i);
		}
	}
}
