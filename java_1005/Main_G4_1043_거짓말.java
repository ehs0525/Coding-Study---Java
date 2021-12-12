package java_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1043_거짓말 {

	static int N, M;
	static boolean[] knows, canExaggerate;
	static boolean[][] coming;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 사람의 수 N과 파티의 수 M
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 진실을 아는 사람의 수와 번호
		knows = new boolean[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			knows[Integer.parseInt(st.nextToken())] = true;
		}

		// 각 파티마다 오는 사람의 수와 번호
		coming = new boolean[M][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			for (int j = 0; j < P; j++) {
				coming[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (knows[i]) {
				dfs(i);
			}
		}

		int count = 0;
		outer: for (int i = 0; i < M; i++) {
			for (int j = 1; j <= N; j++) {
				if (coming[i][j] && knows[j])
					continue outer;
			}
			count++;
		}

		System.out.println(count);
	}

	private static void dfs(int v) {
		for (int i = 0; i < M; i++) {
			if (coming[i][v]) { // v가 참석한 i번째 파티에
				for (int j = 1; j <= N; j++) {
					if (j == v)
						continue;

					if (coming[i][j] && !knows[j]) { // 참석한 모든 사람들은
						knows[j] = true; // 진실을 알게 된다.
						dfs(j); // 소문 퍼뜨리기
					}
				}
			}
		}

	}
}
