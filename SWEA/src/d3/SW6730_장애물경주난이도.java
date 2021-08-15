package d3;

import java.util.*;
import java.io.*;

public class SW6730_장애물경주난이도 {

	public static int T; 
	public static int N;
	public static int blocks[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] upDiffNums = new int[N];
			int[] downDiffNums = new int[N];
			int upMax = 0;
			int downMax = 0;
			
			blocks = new int[N];
			
			
			for(int i = 0; i < N; i++) {
				blocks[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < N-1; i++) {
				
				if( blocks[i] < blocks[i+1]) {
					upDiffNums[i] = blocks[i+1] - blocks[i];
				} else if ( blocks[i] > blocks[i+1]) {
					downDiffNums[i] = blocks[i] - blocks[i+1];
				}
			}
			
			Arrays.sort(upDiffNums);
			Arrays.sort(downDiffNums);
			
			upMax = upDiffNums[N-1];
			downMax = downDiffNums[N-1];
			
			System.out.println("#"+ testcase + " " + upMax + " " + downMax);
			
		}
		
		
	}
}
