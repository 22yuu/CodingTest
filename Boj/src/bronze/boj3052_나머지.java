package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj3052_³ª¸ÓÁö {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums[] = new int[10];
		int count[] = new int[1001];
		int cnt = 0;
		
		for(int i = 0 ; i < 10; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			count[nums[i] % 42]++;
		}
		
		for(int i = 0 ; i < count.length; i++) {
			
			if(count[i] > 0) {
				cnt++;
			}
			
		} 
		System.out.println(cnt);
	}
}
