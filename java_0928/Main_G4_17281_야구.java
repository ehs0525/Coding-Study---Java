package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17281_야구 {

	static int N, max = 0;
	static int[] order; // 타순
	static boolean[] isSelected;
	static int[][] bat; // bat[i][j] : i회의 j번 선수 타격 결과

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		order = new int[10];
		isSelected = new boolean[10];
		bat = new int[N + 1][10];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				bat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		order[4] = 1;
		isSelected[1] = true;
		lineUp(1);
		System.out.println(max);
	}

	// 타순을 정하는 permutation
	private static void lineUp(int index) {
		if (index == 10) {
			max = Integer.max(max, playBall());
			return;
		}

		if (index == 4) {
			lineUp(index + 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (isSelected[i])
				continue;

			order[index] = i;
			isSelected[i] = true;

			lineUp(index + 1);
			isSelected[i] = false;
		}
	}

	// 정해진 타순에 따라 야구 게임을 진행하고 스코어를 반환
	private static int playBall() {
		int rbi = 0;
		int atBat = 1;

		for (int i = 1; i <= N; i++) {
			int out = 0;
			boolean[] onBase = new boolean[8];
			while (out < 3) {
				if (atBat == 10)
					atBat = 1; // 타자 일순

				int hit = bat[i][order[atBat]]; // 타격 결과
				switch (hit) {
				case 1:
				case 2:
				case 3:
				case 4:
					onBase[0] = true;
					for (int j = 7; j >= hit; j--) { // 진루
						onBase[j] = onBase[j - hit];
						onBase[j - hit] = false;
					}
					for (int j = 4; j < 8; j++) { // 적시타인 경우, 득점
						if (onBase[j]) {
							rbi++;
							onBase[j] = false;
						}
					}
					break;
				case 0:
					out++;
					break;
				}

				atBat++;
			}
		}

		return rbi;
	}

}
