package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4948_����Ʈ������ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int end = N*2;
			int cnt = 0;
			if(N == 0) break;
			
			boolean[] prime = new boolean[end+1];
			prime[0]=prime[1]=true;
			
			for(int i =2; i*i <=end; i++) {
				
				// �Ҽ����
				if(!prime[i]) {
					for(int j=i*i; j <=end; j+=i) prime[j] = true;
				}
			}
			
			// �Ҽ� ���
			for(int i = N+1; i <= end; i++) {
				if(!prime[i]) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}
	}
}
