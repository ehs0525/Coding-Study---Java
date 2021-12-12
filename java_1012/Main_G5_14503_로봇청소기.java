package java_1012;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14503_로봇청소기 {

	static class RobotCleaner {
		Point p;
		int dir;

		public RobotCleaner(Point p, int dir) {
			super();
			this.p = p;
			this.dir = dir;
		}
	}

	static int N, M, count = 0;
	static int[][] place;
	static RobotCleaner rc;

	static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 세로 크기 N, 가로 크기 M 입력받기
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 로봇 청소기 정보 입력받기
		st = new StringTokenizer(in.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		rc = new RobotCleaner(new Point(r, c), d);

		// 장소의 상태 입력받기
		place = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 로봇 청소기 작동시키기
		operate();

		System.out.println(count);
	}

	private static void operate() {

		// 1. 현재 위치를 청소한다.
		if (place[rc.p.x][rc.p.y] == 0) {
			place[rc.p.x][rc.p.y] = 2;
			count++;
		}

		// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
		for (int i = 0; i < 4; i++) {
			int nd = (rc.dir + 3) % 4;
			int nr = rc.p.x + dr[nd];
			int nc = rc.p.y + dc[nd];

			if (place[nr][nc] == 0) { // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면,
				rc.dir = nd; // 그 방향으로 회전한 다음
				rc.p = new Point(nr, nc); // 한 칸을 전진하고
				operate(); // 1번부터 진행한다.
				return;
			} else { // 왼쪽 방향에 청소할 공간이 없다면,
				rc.dir = nd; // 그 방향으로 회전하고
				continue; // 2번으로 돌아간다.
			}
		}

		// 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는,
		int nr = rc.p.x + dr[(rc.dir + 2) % 4];
		int nc = rc.p.y + dc[(rc.dir + 2) % 4];
		if (place[nr][nc] == 1) { // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는
			return; // 작동이 멈춘다.
		}
		rc.dir = rc.dir; // 바라보는 방향을 유지한 채로
		rc.p = new Point(rc.p.x + dr[(rc.dir + 2) % 4], rc.p.y + dc[(rc.dir + 2) % 4]); // 한 칸 후진을 하고
		operate(); // 2번으로 돌아간다.
	}

}
