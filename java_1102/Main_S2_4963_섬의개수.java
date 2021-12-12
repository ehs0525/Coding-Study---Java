package java_1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_4963_섬의개수 {

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
			// 모든 사각형에 대하여 dfs
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
		// 지도 밖으로 나가면 종료
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;

		if (map[x][y] == 1) { // 섬이라면(아직 방문하지 않은 사각형)
			map[x][y] = 0; // 바다 처리(방문함)

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				dfs(nx, ny);
			}
			return true;
		}
		// 이까지 왔다는 것은 해당 사각형이 바다라는 것
		return false;
	}

}
