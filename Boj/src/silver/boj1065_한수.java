package silver;

import java.util.*;
import java.io.*;

public class boj1065_ÇÑ¼ö {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 1; i <= num; i++) {			
			if(i <= 99) {
				answer++;
			} else {
				String[] numStr = Integer.toString(i).split("");
				
				int hundreds = Integer.parseInt(numStr[0]); 
				int tens = Integer.parseInt(numStr[1]);
				int units = Integer.parseInt(numStr[2]);
				
				if(tens - hundreds == units - tens) answer++;
			}
		}
		
		System.out.println(answer);
		

	}

}
