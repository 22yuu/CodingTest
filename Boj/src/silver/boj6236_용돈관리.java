package silver;

import java.util.*;
import java.io.*;

public class boj6236_용돈관리 {

	public static int N, M;
	public static int[] bank;
	public static int total_money;
	
	public static boolean solve(int k) {
		int amount = 0;
		int cnt = 0;
		
		for(int i = 0 ; i < N; i++) {
			
			if(amount < bank[i]) {
				amount = k;
				cnt++;
			}
			amount -= bank[i];
			
			if(amount < 0) return false;
		}
		if(cnt <= M) return true;
		else return false;
		
	}
	
	public static int bs() {
		int l = 0;
		int r = total_money;
		int m;
		
		while(l <= r) {
			m = (l+r) / 2;
			
			if(solve(m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		return l;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bank = new int[N];
		
		total_money = 0; //총 사용할 돈 
		
		for(int i = 0 ; i < N; i++) {
			bank[i] = Integer.parseInt(br.readLine());
			total_money += bank[i];
		}
		
		
		int answer = bs();
		
		System.out.println(answer);

	}

}
