package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1966_������ť {
	
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
			
			int numOfDoc = sc.nextInt(); // ������ ����
			int docPos = sc.nextInt(); // �� ��°�� ���� �ִ���
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
					if(com < p.prior) { // �� ���� ������ ū ���ڰ� �����ϸ�
						flag = true;
					}
				}
				
				if(flag) {
					queue.offer(queue.poll());
				} else { // ���� �� ���� ���ڰ� ���� Ŭ ��
					if(queue.poll().location == docPos) {
						answer = priority.length - queue.size();
					}
				}
			}
			System.out.println(answer);
		}
	}
}
