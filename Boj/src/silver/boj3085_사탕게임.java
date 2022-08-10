package silver;

import java.io.*;
import java.util.*;

public class boj3085_�������� {
	
	private static int N;
	private static char[][] map;
	private static int answer = Integer.MIN_VALUE;
	
	public static void checkMap() {
		
		int count = 0;
		
		// ���� �˻�
		for(int i = 0; i < N; i++) {
			count = 1;
			for(int j = 0 ; j < N-1; j++) {
				if(map[i][j] == map[i][j+1]) count++;
				else count = 1;
				answer = Math.max(answer, count);
			}
		}
		
		// ���� �˻�
		for(int j = 0; j < N; j++) {
			count = 1;
			for(int i = 0; i < N-1; i++) {
				if(map[i][j] == map[i+1][j]) count++;
				else count = 1;
				answer = Math.max(answer, count);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		
		// map �ʱ�ȭ
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// ���η� swap
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
//				swap(i, j, true);
				char temp = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = temp;
//				print();
//				System.out.println("****** swap! *******");
				checkMap();
//				swap(i, j, true);
				temp = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = temp;
//				print();
//				System.out.println("****** back! *******");
				
			}
		}
		
		// ���η� swap
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N-1; i++) {
//				swap(j,i, false);
				char temp = map[i][j];
				map[i][j] = map[i+1][j];
				map[i+1][j] = temp;
				
				checkMap();
//				swap(j,i, false);
				
				temp = map[i][j];
				map[i][j] = map[i+1][j];
				map[i+1][j] = temp;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void swap(int i, int j, boolean directions) {
		if(directions) {
			// true �� �� ���� ����
			char temp = map[i][j];
			map[i][j] = map[i][j+1];
			map[i][j+1] = temp;
		} else {
			// ���� ����
			char temp = map[i][j];
			map[i][j] = map[i+1][j];
			map[i+1][j] = temp;
		}
	}
	
	
	public static void print() {
		for(int i = 0; i < N; i++) { 
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
