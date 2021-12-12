package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_2644_�̼���� {

	public static int n, a, b; // ��ü ����� ��, �̼��� ����ؾ� �ϴ� �� ����� ��ȣ
	public static ArrayList<ArrayList<Integer>> ilchon = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited;
	public static int[] chonsu; // �ִ� �Ÿ� �� �湮 ����

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(in.readLine());
		chonsu = new int[n + 1];

		// �׷��� �� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for (int i = 0; i <= n; i++) {
			ilchon.add(new ArrayList<Integer>());
			chonsu[i] = -1;
		}

		st = new StringTokenizer(in.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(in.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ilchon.get(x).add(y);
			ilchon.get(y).add(x);
		}
		chonsu[a] = 0;

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(a);

		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == b)
				return chonsu[curr];

			for (int i = 0; i < ilchon.get(curr).size(); i++) {
				int next = ilchon.get(curr).get(i);
				// ���� �湮���� �ʾҴٸ�
				if (chonsu[next] == -1) {
					chonsu[next] = chonsu[curr] + 1;
					q.offer(next);
				}
			}
		}

		return -1;
	}

}
