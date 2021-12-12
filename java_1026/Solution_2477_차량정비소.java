package java_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477_차량정비소 {

	static class Customer {
		int no, arriveTime;
		int recNo, recStartTime, recEndTime;
		int repNo, repStartTime, repEndTime;

		public Customer(int no, int arriveTime) {
			this.no = no;
			this.arriveTime = arriveTime;
		}
	}

	static int N, M, K, A, B;
	static int[] a, b, t;

	static Queue<Customer> recQ = new LinkedList<Customer>();
	static PriorityQueue<Customer> repQ = new PriorityQueue<>(new Comparator<Customer>() {
		@Override
		public int compare(Customer o1, Customer o2) {
			if (o1.recEndTime != o2.recEndTime) {
				return Integer.compare(o1.recEndTime, o2.recEndTime);
			} else {
				return Integer.compare(o1.no, o2.no);
			}
		}
	});

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int x = 1; x <= T; x++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			a = new int[N + 1];
			b = new int[M + 1];
			t = new int[K + 1];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= K; i++) {
				t[i] = Integer.parseInt(st.nextToken());
				recQ.offer(new Customer(i, t[i]));
			}

			sb.append("#").append(x).append(" ").append(getSum()).append("\n");
		}

		System.out.println(sb);
	}

	private static int getSum() {
		int t = 0, cnt = 0, ans = 0;

		Customer[] rec = new Customer[N + 1];
		Customer[] rep = new Customer[M + 1];

		while (true) {
			// 접수 창구 -> 정비 창구 대기줄
			for (int i = 1; i <= N; i++) {
				if (rec[i] != null) {
					Customer c = rec[i];

					if (t >= c.recStartTime + a[i]) {
						c.recEndTime = t;
						repQ.offer(c);
						rec[i] = null;
					}
				}
			}

			// 고객 도착 -> 접수 창구
			for (int i = 1; i <= N; i++) {
				if (rec[i] == null) {
					if (!recQ.isEmpty() && t >= recQ.peek().arriveTime) {
						Customer c = recQ.poll();
						c.recNo = i;
						c.recStartTime = t;
						rec[i] = c;
					}
				}
			}

			// 정비 창구 -> 고객 만족도 조사
			for (int i = 1; i <= M; i++) {
				if (rep[i] != null) {
					Customer c = rep[i];

					if (t >= c.repStartTime + b[i]) {
						rep[i] = null;
						cnt++;
						if (c.recNo == A && c.repNo == B)
							ans += c.no;
					}
				}
			}

			if (cnt == K)
				break;

			// 정비 창구 대기줄 -> 정비 창구
			for (int i = 1; i <= M; i++) {
				if (rep[i] == null) {
					// 먼저 기다리는 고객이 우선한다.
					if (!repQ.isEmpty()) {
						Customer c = repQ.poll();
						c.repNo = i;
						c.repStartTime = t;
						rep[i] = c;
					}
				}
			}

			t++;

		}

		return ans != 0 ? ans : -1;
	}

}
