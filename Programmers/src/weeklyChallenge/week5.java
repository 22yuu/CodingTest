package weeklyChallenge;

import java.util.*;
import java.io.*;

public class week5 {

	public static char[] moum = {'A', 'E', 'I', 'O', 'U' };
	
	
	public static int getResult(String word) {
		int answer = 0;
		int mul = 781;
		
		for(int i = 0; i < word.length(); i++) {
			for(int j = 0; j < moum.length; j++) {
				if(word.charAt(i) == moum[j]) {
					answer += 1 + j * mul;
				}
			}
			mul = (mul) / 5;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		String word = "AAAAE";
		
		System.out.println(getResult(word));
	}
}
