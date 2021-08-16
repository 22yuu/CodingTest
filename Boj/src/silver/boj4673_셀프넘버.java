package silver;

public class boj4673_¼¿ÇÁ³Ñ¹ö {
	
	public static int d(int n) {
		
		int temp = n;
		int sum = n;
		
		while(temp > 0) {
			sum += temp % 10;
			temp = temp / 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		

		int count = 0;
		
		int[] numIdx = new int[10001];
		numIdx[0] = 1;
		
		for(int i = 1; i <= 10000; i++) {
			int idx = d(i);
			
			if(idx <= 10000) {
				numIdx[idx] = 1;
			}
		}
		
		for(int i = 0; i < numIdx.length; i++) {
			if(numIdx[i] == 0) System.out.println(i);
		}
	}
}