package DP;

import java.util.*;
import java.io.*;

public class DP_효율적인화폐구성 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// n개의 화폐 단위 정보 입력
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
		int[] d = new int[m+1];
		Arrays.fill(d, 10001);
		
		// DP 진행
		d[0] = 0;
		for(int i =0; i< n; i++) {
			for(int j = arr[i]; j <= m; j++) {
				if(d[j - arr[i]] != 10001) {
					d[j] = Math.min(d[j], d[j - arr[i]] + 1);
				}
			}
		}
		
		// 계산된 결과 출력
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
        
	}
}
