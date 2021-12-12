package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_�������ű��1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] house = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp[i][j][0] : ���� ������ ������ �������� (i, j)�� �̵���Ű�� ����� ����
		// dp[i][j][1] : ���� ������ ������ �������� (i, j)�� �̵���Ű�� ����� ����
		// dp[i][j][2] : ���� ������ �밢���� �������� (i, j)�� �̵���Ű�� ����� ����

		// ���� ó���� �������� (1, 1)�� (1, 2)�� �����ϰ� �ְ�, ������ �����̴�.
		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				// if (state[i][j] == 0) {
				// ���η� ������ ����� ��
				if (j - 1 > 0 && house[i][j] == 0) // �� ���� ���̰� �� ĭ�� �� �ű� �� �ִ�.
					// ���� �������� ���� �Ǵ� �밢������ ����Ǿ��� ���̴�(�׸��� ����� ���)
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

				// ���η� ������ ����� ��
				if (i - 1 > 0 && house[i][j] == 0)
					// ���� �������� ���� �Ǵ� �밢������ ����Ǿ��� ���̴�(�׸��� �ʷϻ� ���)
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

				// �밢������ ������ ����� ��
				if (i - 1 > 0 && j - 1 > 0 && house[i][j] == 0 && house[i][j - 1] == 0 && house[i - 1][j] == 0)
					// ���� �������� ����, ���� �Ǵ� �밢������ ����Ǿ��� ���̴�(�׸��� �Ķ��� ���)
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				// }
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}

}
