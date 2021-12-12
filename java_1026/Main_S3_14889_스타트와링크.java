package java_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14889_스타트와링크 {

	static int N;
	static int[][] S;
	static boolean[] isStartTeam;
	static int startCnt = 0, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		S = new int[N][N];
		isStartTeam = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divideIntoTeams(0);
		System.out.println(min);
	}

	private static void divideIntoTeams(int index) {
		if (startCnt > N / 2)
			return;

		if (index == N && startCnt == N / 2) {
			min = Integer.min(min, getCapDiff());
			return;
		}

		if (index == N)
			return;

		isStartTeam[index] = true;
		startCnt++;
		divideIntoTeams(index + 1);

		isStartTeam[index] = false;
		startCnt--;
		divideIntoTeams(index + 1);
	}

	private static int getCapDiff() {
		int startCap = 0, linkCap = 0;

		for (int i = 0; i < N; i++) {
			if (isStartTeam[i]) {
				for (int j = 0; j < N; j++) {
					if (isStartTeam[j]) {
						startCap += S[i][j];
					}
				}
			} else {
				for (int j = 0; j < N; j++) {
					if (!isStartTeam[j]) {
						linkCap += S[i][j];
					}
				}
			}
		}

		return Math.abs(startCap - linkCap);
	}

}
