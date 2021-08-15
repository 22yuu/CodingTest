package bronze;


/*
 * 정문으로부터 걷는 거리가 가장 짧도록 방을 배정
 * w개의 방 H층
 * 엘리베이터는 가장 왼쪽
 * H x W 형태 호텔
 * 호텔 정문은 일층 엘리베이터 바로 앞
 * 정문에서 엘리베이터까지의 거리는 무시
 * 모든 인접한 두 방 사이의 거리는 1
 * 
 * 몇 번째 손님(N)을 층(H)으로 나누면
 * 몫+1 방 번호가 되고, 나머지는 층수가 된다.
 * 이 때, 나머지가 0일 경우 꼭대기층에 해당한다.
 * 
 * 여기까지 로직은 맞았는데 
 * N과 H가 동일할 경우를 생각 못해서 틀림...
 * 만약 N = 6, H = 6, W = 12
 * 일 경우 몫+1((N/H)+1)을 해버리면 2가 되어 602가 된다.
 * 601이 나와야 하므로 몫이 1이 나올 경우에는 1로 설정한다.
 * 
 * */
import java.util.*;
import java.io.*;

public class boi10250_ACM호텔 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // testcase
		
		for(int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int roomNum = (N / H == 1)? N/H : (N/H) + 1; // 방번호
			int floorNum = (N % H == 0)? H : N % H; // 층수
			
			System.out.println(floorNum*100+roomNum);
		}
		
		br.close();
		bw.close();
	}
}