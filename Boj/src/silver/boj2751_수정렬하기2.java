package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		for(int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
		}
	
		Arrays.sort(arr);
		
		for(int num : arr) {
            bw.write(num+"\n");
		}
        bw.flush();
        
        bf.close();
        bw.close();
	}
}
