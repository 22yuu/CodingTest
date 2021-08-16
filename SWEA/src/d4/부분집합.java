package d4;

import java.util.*;
import java.io.*;

public class 부분집합 {
	
	static int N;
	static boolean visited[];
	
	static void PowerSet(int idx) {
		if(idx == N) {
			
			System.out.println(Arrays.toString(visited));
			return;
		}
		System.out.println(Arrays.toString(visited));
		visited[idx] = true;
		PowerSet(idx+1);
		visited[idx] = false;
		PowerSet(idx+1);
	}
	
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 5;
		visited = new boolean[N];
		PowerSet(0);
	}
}
