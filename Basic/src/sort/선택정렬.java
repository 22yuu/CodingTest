package sort;


/*
 *  선택정렬
 *  가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복
 *  
 *  시간복잡도 : O(N^2);
 */
public class 선택정렬 {

	public static void main(String[] args) {
		int array[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		int temp = 0;
		
		for(int i = 0; i < array.length; i++) {
			int min_index = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[min_index] > array[j]) {
					min_index = j;
				}
			}
			
			temp = array[min_index];
			array[min_index] = array[i];
			array[i] = temp;
		}
		
		for(int n : array) System.out.println(n);
	}
}
