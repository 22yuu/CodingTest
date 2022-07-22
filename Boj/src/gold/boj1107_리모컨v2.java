package gold;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/board/view/46120 반례모음

public class boj1107_리모컨v2 {

	private static int N, M;
	private static boolean[] buttons;
	private static List<Integer> list = new ArrayList<>();
	private static int length;
	
	public static void makeNums(int idx, String num) {
		
//		if(idx == length) return;
		
		if(idx == length) {
			System.out.println(num);
//			if(!num.equals("")) list.add(Integer.parseInt(num));
			list.add(Integer.parseInt(num));
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(buttons[i]) continue;
			makeNums(idx+1, num + i);
//			if(!num.equals("")) list.add(Integer.parseInt(num));
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String targetNum = br.readLine();
		length = targetNum.length();
		N = Integer.parseInt(targetNum);
		M = Integer.parseInt(br.readLine());
		
		buttons = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			buttons[idx] = true;
		}
		
		// Target Number가 100인 경우
		if(N == 100) {
			System.out.println(0);
			return;
		} else if(M == 0) {
			// 고장난 버튼이 없는 M = 0 인 경우
			System.out.println(length);
			return;
		} else if(M == 10) {
			// +,- 버튼을 제외한 모든 숫자 버튼이 고장난 M = 10인 경우
			System.out.println(100 - N);
			return;
		}
		
		// 위의 초기 조건에 포함이 안된 경우 버튼의 조합으로 Target Number의 length길이 만큼 넘버를 생성해서 차이가 최소값인 넘버를 찾기
		
		
		makeNums(0, "");
		System.out.println(list);
		
		int min = Integer.MAX_VALUE;
		int diff = 0;
		int minNum = 0;
		int answer = 10000000;
		for(int num: list) {
//			min = Math.min(min, Math.abs(N - num));
			diff = Math.abs(N - num);
			if(min >= diff) {
				min = diff;
				minNum = num;
				
				int pressedCount = (int)(Math.log10(minNum)+1);
				answer = Math.min(answer, min + pressedCount);
				System.out.println(answer);
//				System.out.println(min + " " + minNum + " " + answer);
			}
		}

		System.out.println(min + " " + minNum);
		System.out.println(answer);
		
// 채널 수만큼 누루지 않는 경우도 있음...		
//		int answer = length + min;
//		System.out.println(answer);
/*
 * 	1111
 *  1
 *  1
 *  정답 115
 *  출력 116
 * */
		
		

	}

}
 