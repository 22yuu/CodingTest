package silver;

import java.util.*;
import java.io.*;

public class boj6588_골드바흐의추측 {
	
	private static boolean[] prime;
	
	public static void main(String[] args) throws Exception {
		// 소수 구하기
		prime = new boolean[10000001];
		prime[0]=prime[1]=true;
		
		for(int i = 2; i*i <= prime.length-1; i++) {
			// 소수라면
			if(!prime[i]) {
				for(int j=i*i; j <= prime.length-1; j+= i) prime[j] = true;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = "";
		
		while(!(num = br.readLine()).equals("0") ) {
			
			int n = Integer.parseInt(num);
			boolean isRight = false;
			for(int i = 2; i <= prime.length;i++) {
				int temp = n - i;
				
				if(!prime[temp] && !prime[i]) {
					// !prime[i] 이걸 추가해주니 맞았음... 왜??????
					// 어차피 모두 소수이므로 !prime[temp]으로 조건줘도 맞는거 아닌가...? 
//					System.out.println(n + " = " + i + " + " + temp);
					sb.append(n + " = " + i + " + " + temp).append("\n");
					isRight = true;
					break;
				}
			}
			if(!isRight) {
//				System.out.println("Goldbach's conjecture is wrong.");
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		

	}

}
