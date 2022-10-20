package gold;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/board/view/46120 �ݷʸ���

public class boj1107_������v2 {

	private static int N, M, target;
	private static boolean[] buttons;
	private static List<Integer> list = new ArrayList<>();
	private static int length; // ä�� ���� ��
	private static int MIN = Integer.MAX_VALUE; // ��ư�� ����� �ּ� Ƚ���� ������ ����
	private static int minChannel;
	private static int[] sel;
	private static int answer;
	private static int minValue = Integer.MAX_VALUE;
	
	public static void permutation(int idx, String ch) {
		
		if(idx <= length && idx > 0) {
			StringBuilder sb = new StringBuilder();
			
//			for(int i : sel) sb.append(i);
//			System.out.println(sb.toString());
//			String str = sb.toString();
//			int channel = Integer.parseInt(str);
			int channel = Integer.parseInt(ch);
			list.add(channel);
			
//			int diff = Math.abs(target - channel);
//
//			if(MIN >= diff && channel != 0) {
//				minChannel = channel;
//				MIN = diff;
//				int value = ((int)Math.log10(channel)+1) + diff;
//				System.out.println("value : " + value + " / " + "channel : " + channel + " / " + " diff : " + diff + " / current answer value : " + minValue);
//				answer = Math.min(answer, value);
//				if(minValue > value) {
//					minValue = value;
//				}
//			}
			
			return;
		}
		
		
		for(int i = 0 ; i < 10; i++) {
			if(!buttons[i]) {
//				sel[idx] = i;
				System.out.println(i);
				permutation(idx+1, ch + i);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = 100; // ó�� ���� �ִ� ä���� 100�̴�.
		String targetNum = br.readLine();
		length = targetNum.length();
		target = Integer.parseInt(targetNum);
		N = Integer.parseInt(targetNum);
		M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println(length);
			return;
		}
		
		if(target == 100) {
			System.out.println(0);
			return;
		}
		
		String str = br.readLine();
		String[] arr = str.split(" ");
		buttons = new boolean[10];
		sel = new int[length];

		for(int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			// ���峭 ��ư true!
			buttons[num] = true;
		}
		
		int isPressCount = 0;
		for(int i = 0; i < targetNum.length(); i++) {
			 int num = targetNum.charAt(i) - '0';
			 
			 if(!buttons[num]) isPressCount++;
		}
		
		if(length == isPressCount) {
			System.out.println(length);
			return;
		} 
		
		
		String ch = "";
		permutation(0, ch);
		System.out.println(list);
//		System.out.println(MIN + " " + minChannel);
//		System.out.println(((int)Math.log10(minChannel)+1) + MIN);
//		System.out.println(minValue);
		
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
 