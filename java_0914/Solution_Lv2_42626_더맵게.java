package java_0914;

import java.util.PriorityQueue;

public class Solution_Lv2_42626_´õ¸Ê°Ô {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));

	}

	private static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++)
			pq.offer(scoville[i]);

		int count = 0;
		while (pq.peek() < K) {
			if (pq.size() < 2)
				return -1;

			int first = pq.poll();
			int second = pq.poll();
			int mixed = first + second * 2;
			pq.offer(mixed);
			count++;
		}
		
		return count;
	}

}
