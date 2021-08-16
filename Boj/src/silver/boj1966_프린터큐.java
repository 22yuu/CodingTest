package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1966_프린터큐 {
	
	static class solution {
		
		
	}
	
	static class Printer {
		int location, prior;
		
		public Printer(int doc, int prior) {
			this.location = doc;
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <=T; testcase++) {
			
			Queue<Printer> queue = new LinkedList<>();
			
			int numOfDoc = sc.nextInt(); // 문서의 개수
			int docPos = sc.nextInt(); // 몇 번째에 놓여 있는지
			int priority[] = new int[numOfDoc];
			int answer = 0;
			
			for(int i = 0; i < priority.length; i++) {
				priority[i] = sc.nextInt();
				queue.offer(new Printer(i, priority[i]));
			}
			
			while(!queue.isEmpty()) {
				boolean flag = false;
				int com = queue.peek().prior;
				for(Printer p : queue) {
					if(com < p.prior) { // 맨 앞의 수보다 큰 숫자가 존재하면
						flag = true;
					}
				}
				
				if(flag) {
					queue.offer(queue.poll());
				} else { // 현재 맨 앞의 숫자가 가장 클 때
					if(queue.poll().location == docPos) {
						answer = priority.length - queue.size();
					}
				}
			}
			System.out.println(answer);
		}
	}
}
