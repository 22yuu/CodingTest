package silver;

import java.util.*;
import java.io.*;


public class boj9020_골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		boolean prime[];
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int num = Integer.parseInt(br.readLine());
			prime = new boolean[num+1];
			prime[0]=prime[1]=true;
			GoldBach gb = new GoldBach(-1, -1);
			
			for(int i = 2; i*i <= num; i++) {
				
				if(!prime[i]) {
					for(int j=i*i; j<= num; j+=i) prime[j] = true; 
				}
			}

			for(int i = 2; i <= num; i++) {
				for(int j = 2; j <= num; j++) {
			
					if(!prime[i] && !prime[j]) { // 소수이면 더하기
						int sum = i+j;
						
						if(num == sum) {
							int minus = Math.abs(i-j);
							if(gb.i == -1) {
								gb = new GoldBach(i, j);
							} else if(gb.minus > minus) {
								gb = new GoldBach(i, j);
							}
							break;
						}
					}
				}
			}
			bw.write(gb.i + " " + gb.j + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static class GoldBach {
		int i, j, minus;
		
		public GoldBach(int i, int j) {
			this.i = i;
			this.j = j;
			this.minus = Math.abs(i-j);
		}
	}
}
