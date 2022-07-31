package silver;

import java.util.*;
import java.io.*;

public class boj11723_집합 {

	private static Set<Integer> set;
	private static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] order = str.split(" ");
			
//			add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//			remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//			check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//			toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//			all: S를 {1, 2, ..., 20} 으로 바꾼다.
//			empty: S를 공집합으로 바꾼다. 
			int num = 0;
			if(order.length > 1) {
				num = Integer.parseInt(order[1]);
			}
			
			if(order[0].equals("add")) {
				set.add(num);
			} else if(order[0].equals("remove")) {
				set.remove(num);
			} else if(order[0].equals("check")) {
				if(set.contains(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if(order[0].equals("toggle")) {
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
			} else if(order[0].equals("all")) {
				set.addAll(list);
			} else {
				// emtpy
				set.removeAll(list);
			}
		} // end for
		
		System.out.println(sb.toString());

	}

}
