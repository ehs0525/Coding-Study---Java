package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17281_�߱� {

	static int N, max = 0;
	static int[] order; // Ÿ��
	static boolean[] isSelected;
	static int[][] bat; // bat[i][j] : iȸ�� j�� ���� Ÿ�� ���

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

	// Ÿ���� ���ϴ� permutation
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

	// ������ Ÿ���� ���� �߱� ������ �����ϰ� ���ھ ��ȯ
	private static int playBall() {
		int rbi = 0;
		int atBat = 1;

		for (int i = 1; i <= N; i++) {
			int out = 0;
			boolean[] onBase = new boolean[8];
			while (out < 3) {
				if (atBat == 10)
					atBat = 1; // Ÿ�� �ϼ�

				int hit = bat[i][order[atBat]]; // Ÿ�� ���
				switch (hit) {
				case 1:
				case 2:
				case 3:
				case 4:
					onBase[0] = true;
					for (int j = 7; j >= hit; j--) { // ����
						onBase[j] = onBase[j - hit];
						onBase[j - hit] = false;
					}
					for (int j = 4; j < 8; j++) { // ����Ÿ�� ���, ����
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
