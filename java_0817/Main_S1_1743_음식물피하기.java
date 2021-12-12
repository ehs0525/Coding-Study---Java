package java_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1743_���Ĺ����ϱ� {

	static int N, M, food_waste;
	static int[][] koresco;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		koresco = new int[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			koresco[r][c] = 1;
		}

		int max = Integer.MIN_VALUE;
		// ��� ��ġ�� ���Ͽ� ���Ĺ� ����
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				food_waste = 0;
				// ���� ��ġ���� DFS ����
				dfs(i, j);
				max = Integer.max(max, food_waste);
			}
		}
		
		System.out.println(max);
	}

	// DFS�� Ư�� ��带 �湮�ϰ� ����� ��� ���鵵 �湮
	private static void dfs(int x, int y) {
		// �־��� ������ ����� ��쿡�� ��� ����
		if (x < 1 || x > N || y < 1 || y > M)
			return;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// ���� ��ġ�� ���Ĺ� �����Ⱑ �ִٸ�
		if (koresco[x][y] == 1) {
			// �ش� ��ġ�� ���Ĺ� ������ �ݱ�(�湮 ó������ ����)
			koresco[x][y] = 0;
			food_waste++;

			// ��, ��, ��, ���� ��ġ�鵵 ��� ��������� ȣ��
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				dfs(nx, ny);
			}
		}
	}

}
