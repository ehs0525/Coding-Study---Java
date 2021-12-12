package java_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_7569_≈‰∏∂≈‰ {

	static class Tomato {
		int x, y, z;

		public Tomato(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static int M, N, H, unripe = 0, day = 0;
	static int[][][] tomatoes;
	static Queue<Tomato> ripe = new LinkedList<Tomato>();

	static int[] dx = { 0, 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoes = new int[N][M][H];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int k = 0; k < M; k++) {
					tomatoes[j][k][i] = Integer.parseInt(st.nextToken());
					if (tomatoes[j][k][i] == 0) {
						unripe++;
					} else if (tomatoes[j][k][i] == 1) {
						ripe.offer(new Tomato(j, k, i));
					}
				}
			}
		}

		if (unripe == 0) {
			System.out.println(0);
		} else {
			bfs();
			if (unripe > 0) {
				System.out.println(-1);
			} else {
				System.out.println(day);
			}
		}
	}

	private static void bfs() {
		while (!ripe.isEmpty()) {
			Tomato curr = ripe.poll();

			for (int i = 0; i < 6; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int nz = curr.z + dz[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if (tomatoes[nx][ny][nz] == 0) {
						ripe.offer(new Tomato(nx, ny, nz));
						tomatoes[nx][ny][nz] = tomatoes[curr.x][curr.y][curr.z] + 1;
						unripe--;
						day = Integer.max(day, tomatoes[nx][ny][nz] - 1);
					}
				}
			}
		}

	}

}
