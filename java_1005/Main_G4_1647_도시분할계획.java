package java_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1647_도시분할계획 {

	public static class Road implements Comparable<Road> {
		int houseA, houseB, cost;

		public Road(int houseA, int houseB, int cost) {
			super();
			this.houseA = houseA;
			this.houseB = houseB;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static int N, M;
	public static int[] parents;
	public static Road[] roads;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		roads = new Road[M];
		// 모든 간선에 대한 정보를 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			roads[i] = new Road(A, B, C);
		}

		Arrays.sort(roads);
		int max = 0; // MST에 포함되는 길 중 가장 유지비가 큰 길의 유지비
		int count = 0, result = 0;

		make();
		for (Road road : roads) {
			if (union(road.houseA, road.houseB)) {
				result += road.cost;
				max = road.cost;
				if (++count == N - 1)
					break;
			}
		}

		System.out.println(result - max);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

	}

}
