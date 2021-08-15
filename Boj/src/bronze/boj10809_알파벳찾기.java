package bronze;

import java.util.Scanner;

class Solution {
	
}

public class boj10809_¾ËÆÄºªÃ£±â {
	
	static char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int index[] = new int[26];
	
	public static int findIndex(char c) {

		int idx = 0;
		
		for(int i = 0; i  < alphabet.length; i++) {
			if(alphabet[i] == c) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String str = sc.next();
		
		for(int i = 0; i < 26; i++) {
			index[i] = -1;
		}
		
		for(int i = 0; i < str.length(); i++) {
			
			if(i == 0) {
				index[findIndex(str.charAt(i))] = 0;
				continue;
			} else if (index[findIndex(str.charAt(i))] == -1){
				index[findIndex(str.charAt(i))] = i;
			}
			
			
		}
		
		
		for(int i = 0; i < 26; i++)
			System.out.print(index[i] + " ");
	}
}
