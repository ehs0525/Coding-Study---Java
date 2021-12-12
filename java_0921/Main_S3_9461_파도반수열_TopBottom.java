package java_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9461_�ĵ��ݼ���_TopBottom {

	// �� �� ���� ����� �޸������̼��ϱ� ���� �迭 �ʱ�ȭ
	public static long[] d = new long[101];

	// �ĵ��� �Լ��� ����Լ��� ���� (ž�ٿ� ���)
	public static long padovan(int x) {
		// ���� ����(1~3�� �� 1, 4~5�� �� 2�� ��ȯ)
		if (x <= 3)
			return 1;
		if (x <= 5)
			return 2;

		// �̹� ����� �� �ִ� �����̶�� �״�� ��ȯ
		if (d[x] != 0)
			return d[x];

		// ���� ������� ���� �����̶�� ��ȭ�Ŀ� ���� �ĵ��� ��� ��ȯ
		d[x] = padovan(x - 1) + padovan(x - 5);
		return d[x];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			System.out.println(padovan(N));
		}
	}

}
