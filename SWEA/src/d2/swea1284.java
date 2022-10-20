package d2;

import java.util.*;
import java.io.*;

public class swea1284 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			int P = Integer.parseInt(inputs[0]); // A사 1L당 요금
			int Q = Integer.parseInt(inputs[1]); // B사 R리터 이하 기본요금
			int R = Integer.parseInt(inputs[2]); // B사 R리터 한계선
			int S = Integer.parseInt(inputs[3]); // B사 R리터 초과 당 1L 요금
			int W = Integer.parseInt(inputs[4]); // 종민이가 한달간 사용한 수도의 양
			
			int A_value = P*W; // A사 비용
			int B_value = W <= R ? Q : Q + ((W-R)*S); // B사 비용 W < R 이면 R리터 이하이므로 기본요금 Q : 초과하면 기본요금 Q에서 1L당 S 요금을 지불
			
			if(A_value > B_value) {
				System.out.printf("#%d %d\n", test_case, B_value);
			} else {
				System.out.printf("#%d %d\n", test_case, A_value);
			}
		}
		
	}
}
