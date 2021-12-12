package java_0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_18405_경쟁적전염 {

	public static class Virus implements Comparable<Virus> {
		public int index;
		public int time;
		public int x, y;

		public Virus(int index, int time, int x, int y) {
			super();
			this.index = index;
			this.time = time;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Virus o) {
			return this.index - o.index;
		}
	}

	static int N, K;
	static int[][] testTube;
	static ArrayList<Virus> viruses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		testTube = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				testTube[i][j] = Integer.parseInt(st.nextToken());
				if (testTube[i][j] != 0) {
					viruses.add(new Virus(testTube[i][j], 0, i, j));
				}
			}
		}

		st = new StringTokenizer(in.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		// index가 낮은 바이러스가 먼저 증식하도록 오름차순 정렬
		Collections.sort(viruses);

		multiply(S);

		System.out.println(testTube[X][Y]);
	}

	// S초동안 바이러스를 증식시키기 위한 bfs(너비 우선 탐색)
	private static void multiply(int s) {

		// bfs를 위한 큐 생성
		Queue<Virus> q = new LinkedList<Virus>();
		// 모든 인덱스의 바이러스가 퍼지므로 시작 정점을 모두 삽입
		for (int i = 0; i < viruses.size(); i++)
			q.offer(viruses.get(i));

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 큐가 빌 때까지 bfs 수행
		while (!q.isEmpty()) {
			// 큐의 첫 번째 원소 반환
			Virus virus = q.poll();

			// s초가 흘렀다면 중지
			if (virus.time == s)
				break;

			// 상, 하, 좌, 우의 방향으로 증식하므로 인접칸 큐에 삽입
			for (int i = 0; i < 4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];

				if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
					// 아직 바이러스가 퍼지지 않은 곳이라면 큐에 넣고 증식
					if (testTube[nx][ny] == 0) {
						q.offer(new Virus(virus.index, virus.time + 1, nx, ny));
						testTube[nx][ny] = virus.index;
					}
				}
			}
		}

	}

}
