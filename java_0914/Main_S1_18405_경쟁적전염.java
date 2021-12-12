package java_0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_18405_���������� {

	public static class Virus implements Comparable<Virus> {
		public int index;
		public int time;
		public int x, y;

		public Virus(int index, int time, int x, int y) {
			super();
			this.index = index;
			this.time = time;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Virus o) {
			return this.index - o.index;
		}
	}

	static int N, K;
	static int[][] testTube;
	static ArrayList<Virus> viruses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		testTube = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				testTube[i][j] = Integer.parseInt(st.nextToken());
				if (testTube[i][j] != 0) {
					viruses.add(new Virus(testTube[i][j], 0, i, j));
				}
			}
		}

		st = new StringTokenizer(in.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		// index�� ���� ���̷����� ���� �����ϵ��� �������� ����
		Collections.sort(viruses);

		multiply(S);

		System.out.println(testTube[X][Y]);
	}

	// S�ʵ��� ���̷����� ���Ľ�Ű�� ���� bfs(�ʺ� �켱 Ž��)
	private static void multiply(int s) {

		// bfs�� ���� ť ����
		Queue<Virus> q = new LinkedList<Virus>();
		// ��� �ε����� ���̷����� �����Ƿ� ���� ������ ��� ����
		for (int i = 0; i < viruses.size(); i++)
			q.offer(viruses.get(i));

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// ť�� �� ������ bfs ����
		while (!q.isEmpty()) {
			// ť�� ù ��° ���� ��ȯ
			Virus virus = q.poll();

			// s�ʰ� �귶�ٸ� ����
			if (virus.time == s)
				break;

			// ��, ��, ��, ���� �������� �����ϹǷ� ����ĭ ť�� ����
			for (int i = 0; i < 4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];

				if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
					// ���� ���̷����� ������ ���� ���̶�� ť�� �ְ� ����
					if (testTube[nx][ny] == 0) {
						q.offer(new Virus(virus.index, virus.time + 1, nx, ny));
						testTube[nx][ny] = virus.index;
					}
				}
			}
		}

	}

}
