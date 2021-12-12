package java_1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_14499_¡÷ªÁ¿ß±º∏Æ±‚ {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] move;

	static int[] dice = { 0, 0, 0, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 }; // µø, º≠, ∫œ, ≥≤
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move = new int[K];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < K; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}

		rollDice();
	}

	private static void rollDice() {
		int nx = x;
		int ny = y;

		for (int i = 0; i < K; i++) {
			int tx = nx + dx[move[i]];
			int ty = ny + dy[move[i]];
			if (tx >= 0 && tx < N && ty >= 0 && ty < M) {
				nx = tx;
				ny = ty;
			} else {
				continue;
			}

			switch (move[i]) {
			case 1:
				rollEast();
				break;
			case 2:
				rollWest();
				break;
			case 3:
				rollNorth();
				break;
			case 4:
				rollSouth();
				break;

			}
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			} else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}

			System.out.println(dice[1]);
		}

	}

	private static void rollSouth() {
		int temp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = temp;
	}

	private static void rollNorth() {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = dice[2];
		dice[2] = temp;
	}

	private static void rollWest() {
		int temp = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = temp;
	}

	private static void rollEast() {
		int temp = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = temp;
	}

}
