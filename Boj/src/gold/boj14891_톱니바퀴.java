package gold;

import java.util.*;
import java.io.*;

public class boj14891_톱니바퀴 {
	
	private static int[][] gears = new int[4][8]; // N: 0, S: 1
	private static int K;
	private static int[] gearsDirections = new int[4];
	
	
	private static int[] rotate(int direction, int idx) {
		int[] newArray = new int[8];
		
		// 시계 방향
		if(direction == 1) {
			int last = gears[idx][7];
			for(int i = 0; i < 7; i++) {
				newArray[i+1] = gears[idx][i];
			}
			newArray[0] = last;
		} else if(direction == -1) {
			// 반시계 방향
			int temp = gears[idx][0];
			for(int i = 1; i < 8; i++) {
				newArray[i-1] = gears[idx][i];
			}
			
			newArray[7] = temp;
		}
		
		return newArray;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs[];
		
		for(int i =0 ; i < 4; i++) {
			inputs = br.readLine().split("");
			
			for(int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {

			inputs = br.readLine().split(" ");
			int idx = Integer.parseInt(inputs[0]) - 1;
			int dir = Integer.parseInt(inputs[1]);

			// 돌리기 전 맞닿은 극 확인 2(오른쪽), 6(왼쪽)이 서로 맞닿는 극이다.
			
			if(idx == 0) {
				
				gearsDirections[0] = dir;
				gearsDirections[1] = gearsDirections[0] * -1;
				gearsDirections[2] = gearsDirections[1] * -1;
				gearsDirections[3] = gearsDirections[2] * -1;
				
				
			} else if (idx == 1 || idx == 2) {
				
			} else if(idx == 3) {
				
				
			}
			
			// 돌려
			gears[idx] = rotate(dir, idx);
		}
		
		int sum = 0;
		int operand = 1;
		
		for(int i = 0; i < 4; i++) {
			sum += gears[i][0] == 0 ? 0 : operand;
			operand *= 2;
		}
		
		System.out.println(sum);
	}
}
