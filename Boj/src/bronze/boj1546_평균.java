package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1546_��� {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine()); //�Է� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int max = -1;
		double sum = 0.0;
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(value > max) {
				max = value;
			}
			
			sum+=value;
		}
	
		System.out.println( ((sum/max)*100.0)/N );
	}
}
