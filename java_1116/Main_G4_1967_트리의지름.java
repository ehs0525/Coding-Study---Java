package java_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://gre-eny.tistory.com/232 참고!!
아이디어 : A에서 가장 먼 B를 구함 -> B에서 가장 먼 노드를 구함 = 최대 길이
*/

public class Main_G4_1967_트리의지름 {

	static class Edge {
		int dest;
		int weight;

		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}

	}

	static int n;
	static int[] diameter;
	static ArrayList<Edge>[] edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		edgeList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList[parent].add(new Edge(child, weight));
			edgeList[child].add(new Edge(parent, weight));
		}

		int farestNode = bfs(1);
		int fartherNode = bfs(farestNode);
		System.out.println(diameter[fartherNode]);
	}

	private static int bfs(int start) {
		int max = 0, idx = 0;
		boolean[] visited = new boolean[n + 1];
		diameter = new int[n + 1];

		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(start, 0));
		visited[start] = true;
		while (!q.isEmpty()) {
			Edge curr = q.poll();

			if (edgeList[curr.dest] != null) {
				for (Edge edge : edgeList[curr.dest]) {
					Edge next = edge;
					if (!visited[next.dest]) {
						q.offer(next);
						visited[next.dest] = true;
						diameter[next.dest] = diameter[curr.dest] + next.weight;
						if (diameter[next.dest] > max) {
							max = diameter[next.dest];
							idx = next.dest;
						}
					}
				}
			}
		}

		return idx;
	}

}
