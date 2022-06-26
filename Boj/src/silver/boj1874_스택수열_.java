package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1874_스택수열_ {
	
	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		int[] seq = new int[N];
		int[] answer = new int[N];
		int index = 0;
		
		while(N --> 0) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num > index) {
				
				for(int i = index + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				index = num;
			} else if(stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb);
	}
}
