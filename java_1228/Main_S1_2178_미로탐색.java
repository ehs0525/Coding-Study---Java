package java_1228;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_¹Ì·ÎÅ½»ö {

	public static int N, M;
	public static int[][] maze;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = line[j - 1] - '0';
			}
		}

		System.out.println(bfs(new Point(1, 1)));
	}

	public static int bfs(Point start) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(start);
		maze[start.x][start.y] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (1 <= nx && nx <= N && 1 <= ny && ny <= M && maze[nx][ny] == 1) {
					q.offer(new Point(nx, ny));
					maze[nx][ny] = maze[p.x][p.y] + 1;
				}
			}
		}

		return maze[N][M];
	}

}
