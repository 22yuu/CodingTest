package bronze;

import java.util.*;
import java.io.*;

public class boj1085_직사각형에서탈출 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int min1 = Math.min(w-x, h-y);
		int min2 = Math.min(x-0, y-0);
		
		System.out.println(Math.min(min1, min2));
	}
}
