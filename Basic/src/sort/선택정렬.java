package sort;


/*
 *  ��������
 *  ���� ���� �����͸� ������ �� �տ� �ִ� �����Ϳ� �ٲٰ�, �� ���� ���� �����͸� ������ �տ��� �� ��° �����Ϳ� �ٲٴ� ������ �ݺ�
 *  
 *  �ð����⵵ : O(N^2);
 */
public class �������� {

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
