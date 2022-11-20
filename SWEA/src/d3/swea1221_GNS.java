package d3;

import java.util.*;
import java.io.*;

public class swea1221_GNS {
	
	private static Map<String, Integer> hm = new HashMap<>();
	private static List<Number> list;
	private static int T;
	
	private static class Number implements Comparable<Number>{
		String num;
		int prior;
		
		public Number(String num, int prior) {
			this.num = num;
			this.prior = prior;
		}
		
		@Override
		public int compareTo(Number o) {
			return this.prior - o.prior;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		initHashMap();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			String temp = inputs[0]; // #test_case
			
			list = new ArrayList<>();
			
			int length = Integer.parseInt(inputs[1]);
			
			inputs = br.readLine().split(" ");
			
			for(String s: inputs) {
				int prior = hm.get(s);
				list.add(new Number(s, prior));
			}
			
			Collections.sort(list);
			System.out.println(temp);
			for(int i = 0; i < list.size(); i++) System.out.print(list.get(i).num + " ");
			System.out.println();
			
		}
		
		
		
	}
	
	private static void initHashMap() {
		String str[] = new String[] {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		
		for(int i = 0; i < str.length; i++) hm.put(str[i], i);
		
	}

}
