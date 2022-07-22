package gold;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/board/view/46120 �ݷʸ���

public class boj1107_������v2 {

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
		
		// Target Number�� 100�� ���
		if(N == 100) {
			System.out.println(0);
			return;
		} else if(M == 0) {
			// ���峭 ��ư�� ���� M = 0 �� ���
			System.out.println(length);
			return;
		} else if(M == 10) {
			// +,- ��ư�� ������ ��� ���� ��ư�� ���峭 M = 10�� ���
			System.out.println(100 - N);
			return;
		}
		
		// ���� �ʱ� ���ǿ� ������ �ȵ� ��� ��ư�� �������� Target Number�� length���� ��ŭ �ѹ��� �����ؼ� ���̰� �ּҰ��� �ѹ��� ã��
		
		
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
		
// ä�� ����ŭ ������ �ʴ� ��쵵 ����...		
//		int answer = length + min;
//		System.out.println(answer);
/*
 * 	1111
 *  1
 *  1
 *  ���� 115
 *  ��� 116
 * */
		
		

	}

}
 