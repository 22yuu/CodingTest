package silver;

import java.util.Scanner;

public class boj2941_크로아티아알파벳 {

	static String[] alphabet = {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		String str = sc.next();
		
		for(int i =0; i < alphabet.length; i++) {
			
			if(str.contains(alphabet[i])) {
				str=str.replaceAll(alphabet[i], " ");
			}
		}
		System.out.println(str.length());
	}
}
