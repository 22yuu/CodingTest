package bronze;

import java.util.*;
import java.io.*;

// N���� ������ �ְ�, �� ���ʿ� �ִ� ������ ù ��° ����, ������ ���´� 2���� ����
// 1�� ����, 0�� ����


public class boj21918_���� {

	public static int N, M; // ������ ��, ��ɾ��� ����
	public static int lights[];
	public static int orders[][];
	
	public static void orderFunc(int a, int b, int c) {
		
		if(a == 1) {
			// b��° ������ ���¸� c�� �����Ѵ�.
			lights[b] = c;
			
		} else if(a == 2) {
			// b��°���� c��°������ ������ ���¸� �����Ѵ�.(���� �ִ� ������ ����, ���� �ִ� ������ Ų��.)
			for(int i = b; i <= c; i++) {
				if(lights[i] == 0) lights[i] = 1;
				else lights[i] = 0;
			}
			
		} else if(a == 3) {
			// b ��°���� c��°������ ������ ����.
			for(int i = b; i <= c; i++) {
				lights[i] = 0;
			}
			
		} else {
			// b��°���� c��°������ ������ Ų��.
			for(int i = b; i <= c; i++) {
				lights[i] = 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lights = new int[N+1];
		orders = new int[M][3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			orders[i][0] = a;
			orders[i][1] = b;
			orders[i][2] = c;
		}
		
		for(int i = 0; i < M; i++) {
			orderFunc(orders[i][0], orders[i][1], orders[i][2]);
		}
		
		for(int j = 1; j <= N; j++) {
			System.out.print(lights[j] + " ");
		}
	}
}
