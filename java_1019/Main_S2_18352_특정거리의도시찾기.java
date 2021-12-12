package java_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_18352_Ư���Ÿ��ǵ���ã�� {

	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> cities = new ArrayList<ArrayList<Integer>>();
	static int[] dist; // �ִ� �Ÿ��� �����ϴ� �迭

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			cities.add(new ArrayList<Integer>());
			dist[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			cities.get(A).add(B);
		}

		////////// �Է¹ޱ� �Ϸ� //////////////////

		bfs(X);

		boolean exists = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				exists = true;
			}
		}

		if (!exists) {
			System.out.println(-1);
		}

	}

	private static void bfs(int src) {
		// bfs ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(src);
		dist[src] = 0; // ��� ���ÿ��� ��� ���÷� ���� �ִ� �Ÿ��� 0

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < cities.get(curr).size(); i++) {
				int next = cities.get(curr).get(i);
				// ���� �湮���� ���� ���ö��
				if (dist[next] == -1) {
					q.offer(next);
					dist[next] = dist[curr] + 1;
				}
			}
		}
	}

}
