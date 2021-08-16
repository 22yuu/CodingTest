package bronze;

import java.util.Scanner;

class Main {
	
	public int result(String str) {
		int res = 0;
		int comDif = 0; // °øÂ÷
		
		int length = str.length();
		
		for(int i = 0; i < length; i++) {
			
			if(str.charAt(i) == 'O') {
				comDif += 1;
				res += (1*comDif); 
			} else {
				comDif = 0;
			}
		}
		
		return res;
	}
}


public class boj8958_OXÄûÁî {

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			System.out.println(main.result(str));
		}
		
	}
}
