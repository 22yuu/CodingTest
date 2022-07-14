package bronze;

import java.util.*;
import java.io.*;

public class boj2979_트럭주차 {
	
	 	private static int[] arr;
	    private static int[] fees;
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int totalFee = 0;
	        int feeA = Integer.parseInt(st.nextToken());
	        int feeB = Integer.parseInt(st.nextToken());
	        int feeC = Integer.parseInt(st.nextToken());
	        
	        fees = new int[] {feeA, feeB, feeC};
	        arr = new int[101];
	        
	        
	        for(int i = 0; i < 3; i++) {
	            st = new StringTokenizer(br.readLine());
	            int in = Integer.parseInt(st.nextToken());
	            int out = Integer.parseInt(st.nextToken());
	            
	            for(int t = in; t < out; t++) arr[t]++;
	        }
	        
	        for(int fee : arr) {
	            if(fee == 0) continue;
	            totalFee += fee * fees[fee - 1];
	            System.out.println(fee + " x " + fees[fee - 1] + " : " + totalFee);
	        }
	        
	        System.out.println(totalFee);
	    }
}
