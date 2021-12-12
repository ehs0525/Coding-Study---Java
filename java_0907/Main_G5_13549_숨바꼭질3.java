package java_0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_13549_숨바꼭질3 {

	static class Edge implements Comparable<Edge> {
		int dest, dist;

		public Edge(int dest, int dist) {
			super();
			this.dest = dest;
			this.dist = dist;
		}

		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist)
				return -1;
			return 1;
		}
	}

	static int N, K, V;
	static ArrayList<Edge>[] edgeList; // 간선 정보
	static int[] minDist; // 최소 비용

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
		Arrays.fill(minDist, Integer.MAX_VALUE); // 비용 무한으로 초기화

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
		// 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
		pq.offer(new Edge(start, 0));
		minDist[start] = 0;

		while (!pq.isEmpty()) {
			int current = pq.peek().dest;
			int distance = pq.peek().dist;
			pq.poll();

			// 최단 거리가 아닌 경우 스킵
			if (minDist[current] < distance)
				continue;
			for (int i = 0; i < edgeList[current].size(); i++) {
				// 선택된 노드의 인접 노드
				int next = edgeList[current].get(i).dest;
				// 선택된 노드 거쳐서 인접 노드로 가는 비용
				int nextDistance = distance + edgeList[current].get(i).dist;
				// 기존의 최소 비용보다 더 저렴하다면 교체
				if (nextDistance < minDist[next]) {
					minDist[next] = nextDistance;
					pq.offer(new Edge(next, nextDistance));
				}
			}
		}
	}

}
