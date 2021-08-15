package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj4344_평균은넘겠지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int scores[] = new int[n];
			int sum = 0;
			int cnt = 0;
			double avg = 0;
			
			for(int i =0; i < n; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				sum += scores[i];
			}
			
			avg = (double)sum / n;
			
			for(int i =0; i < n; i++) {
				if(scores[i] > avg) {
					cnt++;
				}
			}
			
			double result = ((double)cnt/n) * 100;
			System.out.println(String.format("%.3f", result)+"%");
		}
	}
}
