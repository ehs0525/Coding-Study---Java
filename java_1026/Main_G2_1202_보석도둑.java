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
 * 논리적인 아이디어는 다음과 같다.

1. 보석을 arraylist로 입력받은 후 무게 순서대로 오름차순 정렬한다.
2. 가방에 담을 수 있는 최대 무게를 입력 받은 후 오름차순 정렬한다.
3. 가격 순서대로 내림차순 정렬을 하는 우선순위 큐를 생성한다.
4. 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아준다.
5. 우선순위 큐의 제일 첫 번째 값(가장 가격이 비싼 보석)을 꺼내어 더해준다.
6. 4 ~ 5를 반복해주면 된다

 * 출처 : https://moonsbeen.tistory.com/194
*/

public class Main_G2_1202_보석도둑 {

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

		// *************** 입력받기 start ***************
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

		
		// ***** 보석리스트와 가방무게배열 정렬하기 *****
		Collections.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return Integer.compare(o1.M, o2.M);
			}
		}); // 보석을 무게 기준 오름차순으로 정렬

		Arrays.sort(C); // 가방에 담을 수 있는 최대 무게를 오름차순으로 정렬
		// **********************************************
		
		
		// ********* 가격 기준 우선순위 큐 생성 *********
		PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return Integer.compare(o2.V, o1.V);
			}
		});
		// **********************************************

		
		// ****** 작은 가방부터 비싼 보석 담아보기 ******
		int index = 0;
		long sum = 0; // ※ long 안쓰면 틀림!!
		for (int i = 0; i < K; i++) {
			while (index < N && jewels.get(index).M <= C[i]) { // i 가방에 넣을 수 없는 보석이 나올 때까지
				pq.add(jewels.get(index++)); // 우선순위 큐에 넣는다.(pq에는 모두 C[i]보다 작은 보석이 담겨있음 -> 후보 개념)
			}
			if (!pq.isEmpty()) {
				sum += pq.poll().V; // 가장 비싼 보석 하나만 넣는다.
			}
		}
		// **********************************************
		
		System.out.println(sum);
	}
}
