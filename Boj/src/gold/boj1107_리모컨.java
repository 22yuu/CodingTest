package gold;

import java.util.*;
import java.io.*;

public class boj1107_리모컨 {

	private static int N, M;
	private static boolean[] buttons;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String targetNum = br.readLine();
		int length = targetNum.length();
		N = Integer.parseInt(targetNum);
		M = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		
		if(N == 100) {
			System.out.println(0);
			return;
		} else if(M == 0) {
			System.out.println(length);
			return;
		} else if(M == 10) {
			System.out.println(100 - N);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxChannel = 0;
		for(int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			buttons[idx] = true;
		}
		
		for(int i =  0; i < 10; i++) {
			if(buttons[i]) continue;
			sb = new StringBuilder();
			
			for(int j = 0; j < length; j++) {
				sb.append(i);
			}
			
			maxChannel = Integer.parseInt(sb.toString());
		}
		
		LinkedList<Integer> stack = new LinkedList<>();
		
		int num = N;
		
		while(num > 0) {
			stack.push(num%10);
			num /= 10;
		}
		
		
		sb = new StringBuilder();
		int answer = 0;
		
		if(N > maxChannel) {
			
			int diff = N - maxChannel;
			sb.append(length + diff);
			answer = Integer.parseInt(sb.toString());
			
		} else {
			
			while(!stack.isEmpty()) {
				int temp = stack.pop();
				
				if(!buttons[temp]) {
					sb.append(temp);
					continue;
				}
				
				int min = Integer.MAX_VALUE;
				int minIdx = 0;
				
				for(int i = 0; i < 10; i++) {
					
					if(buttons[i]) continue;
					
					int diff = Math.abs(temp - i);
					
					if(min > diff) {
						min = diff;
						minIdx = i;
					}
				}
				
				sb.append(minIdx);	
			}
			
			System.out.println(sb.toString());
			
			int channel = Integer.parseInt(sb.toString());
			answer = length + Math.abs(channel - N);
		}
		
		
		
		System.out.println(answer);
		
		
		
		

=======
import java.io.*;
import java.util.*;

public class boj1107_리모컨 {
	
	private static int M;
	private static int Min = Integer.MAX_VALUE;
	private static boolean buttons[] = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int targetNumber = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println((int)Math.log10(targetNumber) + 1);
			return;
		}
		
		String brokens[] = br.readLine().split(" ");
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(brokens[i]);
			buttons[num] = true;
		}
		
		int result = Math.abs(targetNumber - 100);
		for(int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean flag = false;
			for(int j = 0; j < len; j++) {
				if(buttons[str.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int value = Math.abs(targetNumber - i) + len;				
				Min = Math.min(value, Min);
			}
			
		}
		
		System.out.println(Min);
>>>>>>> 037b9cd1829ce65358e958b660e0315f09e8f00e
	}

}
