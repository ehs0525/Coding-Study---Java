package java_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16953_AB {

	static class Number {
		long num;
		int count;

		public Number(long num, int count) {
			super();
			this.num = num;
			this.count = count;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		change(A, B);

	}

	private static void change(long a, long b) {
		Queue<Number> q = new LinkedList<Number>();
		q.offer(new Number(a, 0));

		while (!q.isEmpty()) {
			Number curr = q.poll();

			if (curr.num > b)
				continue;
			if (curr.num == b) {
				System.out.println(curr.count + 1);
				return;
			}

			Number[] next = new Number[2];

			next[0] = new Number(curr.num * 2, curr.count + 1);
			q.offer(next[0]);

			next[1] = new Number(curr.num * 10 + 1, curr.count + 1);
			q.offer(next[1]);
		}

		System.out.println(-1);
	
	}

	
}
