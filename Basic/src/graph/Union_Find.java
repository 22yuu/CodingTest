package graph;


/**
 * Union-Find(유니온-파인드)는 대표적인 그래프 알고리즘입니다. 바로 '합집합 찾기'라는 의미를 가진
 * 알고리즘, 서로소 집합(Disjoint-Set) 알고리즘이라고도 부른다. 구체적으로 여러개의 노드가 존재할 때
 * 두 개의 노드를 선택해서, 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘
 * 
 */



public class Union_Find {

	// 부모 노드를 찾는 함수
	public static int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	// 두 부모 노드를 합치는 함수
	public static void unionParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a; // 부모를 합칠 때는 더 작은 값으로 합친다.
		else parent[a] = b;
	}
	
	// 같은 부모를 가지는지 확인
	public static int findParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a == b) return 1;
		return 0;
	}
	
	
	public static void main(String[] args) {
		int parent[] = new int[11];
		
		//초기화
		for(int i = 1; i <= 10; i++) {
			parent[i] = i; // 자기 자신을 부모로(서로소)
		}
		
		// 연결
		// 1번 그래프
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		unionParent(parent, 3, 4);
		
		// 2번 그래프
		unionParent(parent, 5, 6);
		unionParent(parent, 6, 7);
		unionParent(parent, 7, 8);
		
		System.out.println("1과 5는 연결되어 있나요? " + findParent(parent, 1, 5));
		
		unionParent(parent, 1, 7);
		
		System.out.println("1과 5는 연결되어 있나요? " + findParent(parent, 1, 5));
		
	}
}
