package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_10819_���̸��ִ�� {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// N �Է¹ޱ�
		N = Integer.parseInt(in.readLine());
		// �迭 A�� ����ִ� ���� �Է¹ޱ�
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int max = Integer.MIN_VALUE;
		do {
			max = Integer.max(max, getValue(A));
		} while (np(A));

		System.out.println(max);

	}

	private static int getValue(int[] a) {
		int sum = 0;
		for (int i = 0; i < N - 1; i++)
			sum += Math.abs(a[i] - a[i + 1]);

		return sum;
	}

	// ���� ū ������ ������ true, ������ false
	private static boolean np(int[] numbers) {

		int N = numbers.length;

		// step1. �����(i)�� ã�´�. ����⸦ ���� ��ȯ��ġ(i-1) ã��
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 ��ġ���� ��ȯ�� ū �� ã��
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1 ��ġ���� j ��ġ�� ��ȯ
		swap(numbers, i - 1, j);

		// step4. �����(i)���� �ǵڱ��� �������� ������ ������ ������������ ó��
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;

	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
