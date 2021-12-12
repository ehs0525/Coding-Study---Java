package java_0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485_����������ְ������� {

	static class Edge implements Comparable<Edge> {
		int dest_x, dest_y, dist;

		public Edge(int dest_x, int dest_y, int dist) {
			super();
			this.dest_x = dest_x;
			this.dest_y = dest_y;
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

	static int[][] cave;
	static ArrayList<Edge>[][] edgeList;
	static int[][] minDist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1;; tc++) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			// ������ �� ĭ�� �ִ� ���Ϸ����� ũ�� �Է¹ޱ�
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			edgeList = new ArrayList[N][N];
			minDist = new int[N][N];
			for (int[] md : minDist)
				Arrays.fill(md, Integer.MAX_VALUE);

			// edgeList �����ϱ�
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					edgeList[i][j] = new ArrayList<>();
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
							edgeList[i][j].add(new Edge(nx, ny, cave[nx][ny]));
						}
					}
				}
			}

			dijkstra(0, 0);
			sb.append("Problem ").append(tc).append(": ").append(minDist[N - 1][N - 1]).append("\n");
		}

		System.out.println(sb);
	}

	static void dijkstra(int start_x, int start_y) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // min heap
		// ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
		pq.offer(new Edge(start_x, start_y, cave[start_x][start_y]));
		minDist[start_x][start_y] = cave[start_x][start_y];

		while (!pq.isEmpty()) {
			int curr_x = pq.peek().dest_x;
			int curr_y = pq.peek().dest_y;
			int distance = pq.peek().dist;
			pq.poll();

			// �ִ� �Ÿ��� �ƴ� ��� ��ŵ
			if (minDist[curr_x][curr_y] < distance)
				continue;
			for (int i = 0; i < edgeList[curr_x][curr_y].size(); i++) {
				// ���õ� ����� ���� ���
				int next_x = edgeList[curr_x][curr_y].get(i).dest_x;
				int next_y = edgeList[curr_x][curr_y].get(i).dest_y;
				// ���õ� ��� ���ļ� ���� ���� ���� ���
				int nextDistance = distance + edgeList[curr_x][curr_y].get(i).dist;
				// ������ �ּ� ��뺸�� �� �����ϴٸ� ��ü
				if (nextDistance < minDist[next_x][next_y]) {
					minDist[next_x][next_y] = nextDistance;
					pq.offer(new Edge(next_x, next_y, nextDistance));
				}
			}
		}
	}

}
