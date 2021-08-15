package bronze;

import java.util.*;
import java.io.*;

// N개의 전구가 있고, 맨 왼쪽에 있는 전구를 첫 번째 전구, 전구의 상태는 2가지 있음
// 1은 켜짐, 0은 꺼짐


public class boj21918_전구 {

	public static int N, M; // 전구의 수, 명령어의 개수
	public static int lights[];
	public static int orders[][];
	
	public static void orderFunc(int a, int b, int c) {
		
		if(a == 1) {
			// b번째 전구의 상태를 c로 변경한다.
			lights[b] = c;
			
		} else if(a == 2) {
			// b번째부터 c번째까지의 전구의 상태를 변경한다.(켜져 있는 전구는 끄고, 꺼져 있는 전구는 킨다.)
			for(int i = b; i <= c; i++) {
				if(lights[i] == 0) lights[i] = 1;
				else lights[i] = 0;
			}
			
		} else if(a == 3) {
			// b 번째부터 c번째까지의 전구를 끈다.
			for(int i = b; i <= c; i++) {
				lights[i] = 0;
			}
			
		} else {
			// b번째부터 c번째까지의 전구를 킨다.
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
