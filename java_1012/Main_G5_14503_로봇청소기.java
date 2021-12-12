package java_1012;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14503_�κ�û�ұ� {

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

	static int[] dr = { -1, 0, 1, 0 }; // ��, ��, ��, ��
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// ���� ũ�� N, ���� ũ�� M �Է¹ޱ�
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// �κ� û�ұ� ���� �Է¹ޱ�
		st = new StringTokenizer(in.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		rc = new RobotCleaner(new Point(r, c), d);

		// ����� ���� �Է¹ޱ�
		place = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �κ� û�ұ� �۵���Ű��
		operate();

		System.out.println(count);
	}

	private static void operate() {

		// 1. ���� ��ġ�� û���Ѵ�.
		if (place[rc.p.x][rc.p.y] == 0) {
			place[rc.p.x][rc.p.y] = 2;
			count++;
		}

		// 2. ���� ��ġ���� ���� ������ �������� ���� ������� ���ʴ�� ������ ĭ�� Ž���Ѵ�.
		for (int i = 0; i < 4; i++) {
			int nd = (rc.dir + 3) % 4;
			int nr = rc.p.x + dr[nd];
			int nc = rc.p.y + dc[nd];

			if (place[nr][nc] == 0) { // ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�,
				rc.dir = nd; // �� �������� ȸ���� ����
				rc.p = new Point(nr, nc); // �� ĭ�� �����ϰ�
				operate(); // 1������ �����Ѵ�.
				return;
			} else { // ���� ���⿡ û���� ������ ���ٸ�,
				rc.dir = nd; // �� �������� ȸ���ϰ�
				continue; // 2������ ���ư���.
			}
		}

		// �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��,
		int nr = rc.p.x + dr[(rc.dir + 2) % 4];
		int nc = rc.p.y + dc[(rc.dir + 2) % 4];
		if (place[nr][nc] == 1) { // ���� ������ ���̶� ������ �� �� ���� ��쿡��
			return; // �۵��� �����.
		}
		rc.dir = rc.dir; // �ٶ󺸴� ������ ������ ä��
		rc.p = new Point(rc.p.x + dr[(rc.dir + 2) % 4], rc.p.y + dc[(rc.dir + 2) % 4]); // �� ĭ ������ �ϰ�
		operate(); // 2������ ���ư���.
	}

}
