package sort;

/*
 * 삽입정렬
 * 데이터가 거의 정렬되어 있을 때 훨씬 효율적인 정렬 방법
 * 데이터가 거의 정렬되어 있을 때의 정렬 속도는 퀵정렬보다 빠를수도 있다.
 * 시간복잡도는 O(N^2)이지만 최선의 시간복잡도는 O(N)이다.
 * 선택정렬과 비슷하지만 선택정렬보다 조금 빠르편
 * 데이터가 거의 정렬된 데이터가 주어진다면 삽입 정렬로 문제를 푸는 것이 가자 효율적이고 정답 확률이 높음
 */

public class 삽입정렬 {
	
	public static void main(String[] args) {
		int array[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		
		for(int i = 1; i < array.length; i++) { // 삽입 정렬은 2번째 데이터부터 시작한다. 왜냐하면 첫 번째 데이터는 그 자체로 정렬되어 있다고 판단
			for(int j = i; j > 0; j--) {
				if( array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else {
					break;
				}
			}
		}
		
		for(int n : array) System.out.print(n + " ");
	}
}
