package bronze;

import java.util.*;
import java.io.*;


public class boj3009_네번째점 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x_coord[] = new int[1001]; 
		int y_coord[] = new int[1001]; 
		int x = 0;
		int y = 0;
		for(int i = 0; i <3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			x_coord[x]++;
			y_coord[y]++;
		}

		
		for(int i = 1; i <= 1000; i++) {
			if(x_coord[i] == 1) {
				x = i;
			} 
			if(y_coord[i] == 1) {
				y = i;
			}
		}
		System.out.println(x+" "+y);
	}
}
