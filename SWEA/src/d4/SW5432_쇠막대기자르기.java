package d4;

import java.util.Scanner;
import java.util.Stack;

public class SW5432_쇠막대기자르기 {
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=sc.nextInt();

		Stack<Character> stack = new Stack<Character>();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String bar = sc.next();
			bar = bar.replace("()", "*");
			int num_piece = 0;
			//System.out.println(bar);
			
			for (int i = 0; i < bar.length(); i++) {
				char ch = bar.charAt(i);
				switch(ch) {
					case '(' :
						stack.push(ch);
						break;
					case ')' :
						stack.pop();
						num_piece++;
						break;
					case '*':
						num_piece += stack.size();
					break;
				}
//				System.out.println("***** "+i+" *****");
//				System.out.println("잘린 막대의 조각 수 : "+num_piece);
			}
			System.out.println("#"+test_case+" "+num_piece);
		}
	}
}
