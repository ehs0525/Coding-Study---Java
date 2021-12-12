package java_0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1922_��Ʈ��ũ���� {

	static class Edge implements Comparable<Edge> {

		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, M;
	static Edge[] edgeList;
	static int[] parents; // �θ���Ҹ� ����(Ʈ��ó�� ���)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		edgeList = new Edge[M];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(a, b, c);
		}

		Arrays.sort(edgeList);

		make();

		int cost = 0, count = 0;
		for (Edge e : edgeList) {
			if (union(e.start, e.end)) {
				cost += e.weight;
				if (++count == N - 1)
					break;
			}
		}

		System.out.println(cost);

	}

	private static void make() {
		parents = new int[N + 1];
		// ��� ���Ҹ� �ڽ��� ��ǥ�ڷ� ����
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// a�� ���� ������ ��ǥ�� ã��
	private static int find(int a) {
		if (a == parents[a])
			return a; // �ڽ��� ��ǥ��.
		return parents[a] = find(parents[a]); // �ڽ��� ���� ������ ��ǥ�ڸ� �ڽ��� �θ�� : path compression
	}

	// �� ���Ҹ� �ϳ��� �������� ��ġ��(��ǥ�ڸ� �̿��ؼ� ��ħ)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; // �̹� ���� �������� ��ġ�� ����

		parents[bRoot] = aRoot;
		return true;
	}
}
