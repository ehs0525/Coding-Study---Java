package java_1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_4963_���ǰ��� {

	static int w, h;
	static int[][] map;

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int islands = 0;
			// ��� �簢���� ���Ͽ� dfs
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (dfs(i, j)) {
						islands++;
					}
				}
			}

			System.out.println(islands);
		}
	}

	private static boolean dfs(int x, int y) {
		// ���� ������ ������ ����
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;

		if (map[x][y] == 1) { // ���̶��(���� �湮���� ���� �簢��)
			map[x][y] = 0; // �ٴ� ó��(�湮��)

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				dfs(nx, ny);
			}
			return true;
		}
		// �̱��� �Դٴ� ���� �ش� �簢���� �ٴٶ�� ��
		return false;
	}

}
