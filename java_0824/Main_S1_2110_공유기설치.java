package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_2110_�����⼳ġ {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// ���� ������ �������� ���� �Է¹ޱ�
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N];

		// ���� ��ǥ �Է¹ޱ�
		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(in.readLine());
		Arrays.sort(x);

		int start = 1; // ������ �ּ� �Ÿ�
		int end = x[N - 1] - x[0]; // ������ �ִ� �Ÿ�
		int result = 0;

		while (start <= end) {
			// ���� ������ �� ������ ������ �Ÿ�
			int mid = (start + end) / 2;

			// ù��° ���� ������ ��ġ
			int value = x[0];
			int cnt = 1;

			// ���� ������ ��������� �Ÿ��� mid �̻��̶�� ��ġ�غ���
			for (int i = 1; i < N; i++) {
				if (x[i] - value >= mid) {
					value = x[i];
					cnt++;
				}
			}

			// C�� �̻��� �����⸦ ��ġ�� �� �ִ� ���, �Ÿ��� �������� ������ ���̱�
			if (cnt >= C) {
				start = mid + 1;
				result = mid; // ������ ����� ����
			} else {
				end = mid - 1;
			}
		}

		System.out.println(result);
	}

}
