package bronze;

import java.util.*;
import java.io.*;

public class boj2979_트럭주차 {
	
	private static int[][] trucks;
	private static int[] fees;
	private static List<Integer> in;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		trucks = new int[3][2];
		in = new ArrayList<Integer>();
		
		int feeA = Integer.parseInt(st.nextToken());
		int feeB = Integer.parseInt(st.nextToken());
		int feeC = Integer.parseInt(st.nextToken());
		
		fees = new int[] {feeA, feeB, feeC};
		
		int totalCost = 0;
		
		for(int i = 0 ; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			trucks[i][0] = Integer.parseInt(st.nextToken());
			trucks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trucks, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		int firstTime = trucks[0][0];
		in.add(firstTime);
		totalCost = feeA;
		
		for(int i = firstTime+1 ; i <= 100; i++) {
			
			
			
			for(int j = 0; j < 3; j++) {
				
				if(i == trucks[j][0]) {
					// 주차장에 들어온 시간
					in.add(i);
				}
				
				if(i == trucks[j][1]) {
					// 트럭이 나간 시간
//					totalCost += in.size() * fees[in.size() - 1];
					in.remove(Integer.valueOf(trucks[j][0]));
					continue;
				}
			}
			
			if(in.size() < 1) break;
			
			System.out.print(i+ ":" + in.size() +  "x" + fees[in.size() - 1] + " ");
			totalCost += in.size() * fees[in.size() - 1];
			System.out.println(totalCost);
		}
		
//		for(int[] n : trucks) System.out.println(n[0] + " " + n[1]);
		System.out.println("list size : " + in.size());
		System.out.println(totalCost);
		
		
		
	}

}
