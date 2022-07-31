package silver;

import java.util.*;
import java.io.*;

public class boj11723_���� {

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
			
//			add x: S�� x�� �߰��Ѵ�. (1 �� x �� 20) S�� x�� �̹� �ִ� ��쿡�� ������ �����Ѵ�.
//			remove x: S���� x�� �����Ѵ�. (1 �� x �� 20) S�� x�� ���� ��쿡�� ������ �����Ѵ�.
//			check x: S�� x�� ������ 1��, ������ 0�� ����Ѵ�. (1 �� x �� 20)
//			toggle x: S�� x�� ������ x�� �����ϰ�, ������ x�� �߰��Ѵ�. (1 �� x �� 20)
//			all: S�� {1, 2, ..., 20} ���� �ٲ۴�.
//			empty: S�� ���������� �ٲ۴�. 
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
