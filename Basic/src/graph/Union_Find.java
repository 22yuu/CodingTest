package graph;


/**
 * Union-Find(���Ͽ�-���ε�)�� ��ǥ���� �׷��� �˰����Դϴ�. �ٷ� '������ ã��'��� �ǹ̸� ����
 * �˰���, ���μ� ����(Disjoint-Set) �˰����̶�� �θ���. ��ü������ �������� ��尡 ������ ��
 * �� ���� ��带 �����ؼ�, ���� �� �� ��尡 ���� ���� �׷����� ���ϴ��� �Ǻ��ϴ� �˰���
 * 
 */



public class Union_Find {

	// �θ� ��带 ã�� �Լ�
	public static int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	// �� �θ� ��带 ��ġ�� �Լ�
	public static void unionParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a; // �θ� ��ĥ ���� �� ���� ������ ��ģ��.
		else parent[a] = b;
	}
	
	// ���� �θ� �������� Ȯ��
	public static int findParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a == b) return 1;
		return 0;
	}
	
	
	public static void main(String[] args) {
		int parent[] = new int[11];
		
		//�ʱ�ȭ
		for(int i = 1; i <= 10; i++) {
			parent[i] = i; // �ڱ� �ڽ��� �θ��(���μ�)
		}
		
		// ����
		// 1�� �׷���
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		unionParent(parent, 3, 4);
		
		// 2�� �׷���
		unionParent(parent, 5, 6);
		unionParent(parent, 6, 7);
		unionParent(parent, 7, 8);
		
		System.out.println("1�� 5�� ����Ǿ� �ֳ���? " + findParent(parent, 1, 5));
		
		unionParent(parent, 1, 7);
		
		System.out.println("1�� 5�� ����Ǿ� �ֳ���? " + findParent(parent, 1, 5));
		
	}
}
