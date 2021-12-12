package java_0914;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2638_치즈 {

	static int N, M;
	static int[][] graphPaper;
	static ArrayList<Point> cheese;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graphPaper = new int[N][M];
		cheese = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				graphPaper[i][j] = Integer.parseInt(st.nextToken());
				if (graphPaper[i][j] == 1) {
					cheese.add(new Point(i, j));
				}
			}
		}

		// 외부 공기인지 아닌지 확인하기 위해 가장자리에서 진공포장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
					if (graphPaper[i][j] == 0) {
						vacuumAir(new Point(i, j));
					}
				}
			}
		}

		int hour = 0;
		while (!cheese.isEmpty()) {
			ArrayList<Point> melting = new ArrayList<>();
			for (int i = 0; i < cheese.size(); i++) {
				Point curr = cheese.get(i);
				if (isMeltingAway(curr)) {
					melting.add(cheese.remove(i));
					i--;
				}
			}

			for (int i = 0; i < melting.size(); i++) {
				vacuumAir(melting.get(i));
			}

			hour++;
		}

		System.out.println(hour);
	}

	private static boolean isMeltingAway(Point p) {
		int contact = 0;

		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (graphPaper[nx][ny] == 2) {
					contact++;
				}
			}
		}

		if (contact >= 2)
			return true;
		else
			return false;
	}

	// bfs
	private static void vacuumAir(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		graphPaper[p.x][p.y] = 2; // 방문(진공) 처리

		while (!q.isEmpty()) {
			Point air = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = air.x + dx[i];
				int ny = air.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (graphPaper[nx][ny] == 0) {
						q.offer(new Point(nx, ny));
						graphPaper[nx][ny] = 2;
					}
				}
			}
		}
	}

}
