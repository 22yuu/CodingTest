package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1929_�Ҽ����ϱ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[M+1];
		prime[0]=prime[1]=true;
		
		for(int i =2; i*i <=M; i++) {
			
			// �Ҽ����
			if(!prime[i]) {
				for(int j=i*i; j <=M; j+=i) prime[j] = true;
			}
		}
		
		// �Ҽ� ���
		for(int i = N; i <= M; i++) {
			if(!prime[i]) System.out.println(i);
		}
	}
}
