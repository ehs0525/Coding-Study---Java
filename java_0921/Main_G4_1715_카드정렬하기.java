package java_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_G4_1715_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++)
			pq.offer(Integer.parseInt(in.readLine()));

		int cmp = 0;
		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();

			cmp += first + second;
			pq.offer(first + second);
		}
		
		System.out.println(cmp);
	}

}
