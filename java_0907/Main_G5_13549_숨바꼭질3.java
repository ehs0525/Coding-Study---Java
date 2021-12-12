package java_0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_13549_���ٲ���3 {

	static class Edge implements Comparable<Edge> {
		int dest, dist;

		public Edge(int dest, int dist) {
			super();
			this.dest = dest;
			this.dist = dist;
		}

		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist)
				return -1;
			return 1;
		}
	}

	static int N, K, V;
	static ArrayList<Edge>[] edgeList; // ���� ����
	static int[] minDist; // �ּ� ���

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		V = Integer.max(N, K) * 2;

		edgeList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			edgeList[i] = new ArrayList<>();
		minDist = new int[V];
		Arrays.fill(minDist, Integer.MAX_VALUE); // ��� �������� �ʱ�ȭ

		for (int i = 0; i < V; i++) {
			if (i - 1 >= 0)
				edgeList[i].add(new Edge(i - 1, 1));
			if (i + 1 < V)
				edgeList[i].add(new Edge(i + 1, 1));
			if (0 <= 2 * i && 2 * i < V)
				edgeList[i].add(new Edge(2 * i, 0));
		}

		dijkstra(N);
		System.out.println(minDist[K]);
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // min heap
		// ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
		pq.offer(new Edge(start, 0));
		minDist[start] = 0;

		while (!pq.isEmpty()) {
			int current = pq.peek().dest;
			int distance = pq.peek().dist;
			pq.poll();

			// �ִ� �Ÿ��� �ƴ� ��� ��ŵ
			if (minDist[current] < distance)
				continue;
			for (int i = 0; i < edgeList[current].size(); i++) {
				// ���õ� ����� ���� ���
				int next = edgeList[current].get(i).dest;
				// ���õ� ��� ���ļ� ���� ���� ���� ���
				int nextDistance = distance + edgeList[current].get(i).dist;
				// ������ �ּ� ��뺸�� �� �����ϴٸ� ��ü
				if (nextDistance < minDist[next]) {
					minDist[next] = nextDistance;
					pq.offer(new Edge(next, nextDistance));
				}
			}
		}
	}

}
