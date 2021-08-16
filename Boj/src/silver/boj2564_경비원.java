package silver;

import java.util.*;
import java.io.*;

public class boj2564_경비원 {
	
	public static int W, H;	
	public static int stores;
	public static int positions[][];
	public static int pos, val;
	public static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		stores = Integer.parseInt(br.readLine());
		
		positions = new int[stores][2];
		
		// 상점들 위치 입력 
		for(int  i = 0; i < stores; i++) {
			st = new StringTokenizer(br.readLine());
			
			positions[i][0] = Integer.parseInt(st.nextToken()); // 방향
			positions[i][1] = Integer.parseInt(st.nextToken()); // 위치
		}
		
		// 동근이 위치 입력
		st = new StringTokenizer(br.readLine());
		pos = Integer.parseInt(st.nextToken());
		val = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < stores; i++) {
			if(pos == positions[i][0]) { // 상점의 방향과 동근의 방향이 같다면
				answer += Math.abs(val - positions[i][1]);
			} else {
				if(pos == 1) { // 동근이의 위치가 북쪽이고
					if(positions[i][0] == 2) { // 상점의 위치가 남쪽
						
						if((W/2) >= positions[i][1]) { // 상점의 위치가 가로의 크기를 반 나눴을 때 보다 작거나 같다면 시계방향
							answer += positions[i][1];
							answer += H; // 세로 길이 더함
							answer += val;
						} else {
							answer += W - positions[i][1]; // 반시계반향
							answer += H;
							answer += W - val;
						}
						
					
					} else if(positions[i][0] == 3) { // 
						
					} else if(positions[i][0] == 4){
						
					}
				}
			}
		}
		
		
	}
}
