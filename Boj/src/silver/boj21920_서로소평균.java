package silver;

import java.util.*;
import java.io.*;

public class boj21920_¼­·Î¼ÒÆò±Õ {

	public static int N;
	public static int nums[];
	public static double answer = 0;

	
	public static void cal(List<Integer> list, int n) {
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			while(n % i == 0) {
				n /= i;
				list.add(i);
			}
		}
		
		if(n != 1) {
			list.add(n);
		}
	}
	
	public static boolean isCoprime(List<Integer> list1, List<Integer> list2) {
		
		int size1 = list1.size();
		int size2 = list2.size();
		int trueCnt = 0;
		
		if(size1 > size2) {
			for(int el1 : list1) {
				for(int el2 : list2) {
					if(el1 == el2) {
						trueCnt++;
					}
				}
			}
		} else {
			for(int el1 : list2) {
				for(int el2 : list1) {
					if(el1 == el2) {
						trueCnt++;
					}
				}
			}
		}
		
		if(trueCnt > 0) return false;
		else return true;
		 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2;
		long sum = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int X = Integer.parseInt(br.readLine());
		
		cal(list1, X);
		
		for(int i = 0; i <N; i++) {
			if(X == nums[i]) continue;
			
			list2 = new ArrayList<>();
			
			cal(list2, nums[i]);
			
//			System.out.println(Arrays.toString(list1.toArray()));
//			System.out.println(Arrays.toString(list2.toArray()));
			
			if(isCoprime(list1, list2)) {
				sum += nums[i];
				cnt++;
			}
		}
		
		answer = (double)sum / cnt;
		
		System.out.printf("%.5f", answer);
	}
}
