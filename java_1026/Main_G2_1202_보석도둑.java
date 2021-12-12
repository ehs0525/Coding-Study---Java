package java_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * ������ ���̵��� ������ ����.

1. ������ arraylist�� �Է¹��� �� ���� ������� �������� �����Ѵ�.
2. ���濡 ���� �� �ִ� �ִ� ���Ը� �Է� ���� �� �������� �����Ѵ�.
3. ���� ������� �������� ������ �ϴ� �켱���� ť�� �����Ѵ�.
4. ���� ������ ���� �� �ִ� �ִ� ���Ժ��� �۰ų� ���� ���Ը� ���� ������ �켱���� ť�� ����ش�.
5. �켱���� ť�� ���� ù ��° ��(���� ������ ��� ����)�� ������ �����ش�.
6. 4 ~ 5�� �ݺ����ָ� �ȴ�

 * ��ó : https://moonsbeen.tistory.com/194
*/

public class Main_G2_1202_�������� {

	static class Jewel {
		int M, V;

		public Jewel(int m, int v) {
			M = m;
			V = v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		ArrayList<Jewel> jewels = new ArrayList<>();

		// *************** �Է¹ޱ� start ***************
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] C = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(M, V));
		}

		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(in.readLine());
		}
		// **********************************************

		
		// ***** ��������Ʈ�� ���湫�Թ迭 �����ϱ� *****
		Collections.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return Integer.compare(o1.M, o2.M);
			}
		}); // ������ ���� ���� ������������ ����

		Arrays.sort(C); // ���濡 ���� �� �ִ� �ִ� ���Ը� ������������ ����
		// **********************************************
		
		
		// ********* ���� ���� �켱���� ť ���� *********
		PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return Integer.compare(o2.V, o1.V);
			}
		});
		// **********************************************

		
		// ****** ���� ������� ��� ���� ��ƺ��� ******
		int index = 0;
		long sum = 0; // �� long �Ⱦ��� Ʋ��!!
		for (int i = 0; i < K; i++) {
			while (index < N && jewels.get(index).M <= C[i]) { // i ���濡 ���� �� ���� ������ ���� ������
				pq.add(jewels.get(index++)); // �켱���� ť�� �ִ´�.(pq���� ��� C[i]���� ���� ������ ������� -> �ĺ� ����)
			}
			if (!pq.isEmpty()) {
				sum += pq.poll().V; // ���� ��� ���� �ϳ��� �ִ´�.
			}
		}
		// **********************************************
		
		System.out.println(sum);
	}
}
