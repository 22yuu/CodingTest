package sort;

/*
 * 퀵정렬
 * 퀵 정렬에서는 피벗이 사용된다. 큰 숫자와 작은 숫자를 교환할 때, 교환하기 위한 '기준'을 바로 피벗이라고 표현
 * 대표적인 분할 방식인 호어 분할 방식을 기준으로 퀵 정렬을 설명
 * 
 * 호어 분할 방식
 *  - 리스트에서 첫 번째 데이터를 피벗으로 정한다.
 *  - 피벗을 설정한 뒤 왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾는다.
 *  - 그 다음 큰 데이터와 작은 데이터의 위치를 서로 교환해준다.
 *  - 이러한 과정을 반복하면 왼쪽에서부터 찾는 값과 오른쪽에서 찾는 값의 위치가 서로 엇갈린다.
 *  - 이렇게 두 값이 엇갈린 경우에는 작은 데이터와 피벗의 위치를 서로 변경함으로서 분할을 수행한다.
 *  - 이렇게 분할이 완료되어 피벗에 대하여 정렬이 완료되면
 *  - 피벗의 기준으로 왼쪽은 피벗보다 작은 수, 오른쪽은 피벗보다 큰 수로 정렬이 되어 있을 것이다.
 *  - 이러한 상태에서 왼쪽 리스트와 오른쪽 리스트를 개별적으로 정렬시킴으로서 전체 리스트에 대하여 데이터 정렬이 이루어진다.
 */

public class 퀵정렬 {
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end ) return; // 원소가 1개인 경우 종류
		int pivot = start; // 피벗은 첫 번째 원소
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			// 피벗보다 큰 데이터를 찾을 때까지 반복
			while(left <= end && arr[left] <= arr[pivot]) left++;
			
			// 피벗보다 작은 데이터를 찾을 때까지 반복
			while(right > start && arr[right] >= arr[pivot]) right--;
			
			// 왼쪽과 오른쪽이 엇갈렸다면 작은 데이터와 피벗을 교체
			if(left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			} else { // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			
			// 분할 이후 왼쪽 리스트와 오른쪽 리스트 부분에서 각각 정렬 수행
			quickSort(arr, start, right - 1);
			quickSort(arr, right + 1, end);
			
		}
		
				
	}
	
	public static void main(String[] args) {
		
		int array[] = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
		
		quickSort(array, 0, array.length - 1);
		
		for(int i : array) System.out.print(i + " ");
		
	}
}
