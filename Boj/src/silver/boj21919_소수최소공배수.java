package silver;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class boj21919_소수최소공배수 {
	
	public static int N;
	public static int nums[];
	public static List<Long> primeNumsList;
	public static boolean prime[];
	public static long answer = 1;
	
	
	public static long gcd(long a, long b) {
		if(a%b == 0) return b;
		return gcd(b, a%b);
	}
	
	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		primeNumsList = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 오름차순 정렬
		
		int maxNum = (int)nums[N-1]; // 최대값
		
		prime = new boolean[maxNum+1];
		
		// 에라토네스의 체
		for(int i = 2; i*i <=maxNum; i++) {
			
			if(!prime[i]) { // 배수들 다 제외
				for(int j=i*i; j <=maxNum; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!prime[nums[i]]) primeNumsList.add((long)nums[i]);
		}
		
		answer = primeNumsList.size() == 0 ? 1 : primeNumsList.get(0);
		
		for(int i = 1; i < primeNumsList.size(); i++) {
			answer = lcm(answer, primeNumsList.get(i));
		}
		
		answer = answer == 1? -1 : answer;
		
		System.out.println(answer);
	}
}
