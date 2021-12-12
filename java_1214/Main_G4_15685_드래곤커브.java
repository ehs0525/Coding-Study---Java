package java_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_15685_µå·¡°ïÄ¿ºê {

	public static int N;
	public static int x, y, d, g;
	public static boolean[][] grid = new boolean[101][101];

	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			drawDragonCurve();
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (grid[i][j] && grid[i][j + 1] && grid[i + 1][j] && grid[i + 1][j + 1]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	public static void drawDragonCurve() {
		int[] directions = new int[(int) Math.pow(2, g)];
		directions[0] = d;
		for (int i = 1; i <= g; i++) {
			for (int j = (int) Math.pow(2, i - 1); j < (int) Math.pow(2, i); j++) {
				directions[j] = (directions[(int) Math.pow(2, i) - 1 - j] + 1) % 4;
			}
		}

		grid[y][x] = true;
		for (int i = 0, nx = x, ny = y; i < directions.length; i++) {
			nx += dx[directions[i]];
			ny += dy[directions[i]];
			grid[ny][nx] = true;
		}

	}

}
