package gold;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/board/view/46120 반례모음

public class boj1107_리모컨v2 {

	private static int N, M, target;
	private static boolean[] buttons;
	private static List<Integer> list = new ArrayList<>();
	private static int length; // 채널 길이 수
	private static int MIN = Integer.MAX_VALUE; // 버튼을 누루는 최소 횟수를 저장할 변수
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
		answer = 100; // 처음 보고 있는 채널은 100이다.
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
			// 고장난 버튼 true!
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
 