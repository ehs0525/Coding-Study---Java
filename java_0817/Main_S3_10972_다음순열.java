package java_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_10972_�������� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] perm = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			perm[i] = Integer.parseInt(st.nextToken());

		if (nextPermutation(perm)) {
			for (int i : perm)
				System.out.print(i + " ");
		} else {
			System.out.print(-1);
		}
	}

	private static boolean nextPermutation(int[] perm) {

		int len = perm.length;

		// 1. ����� ã��
		int i = len - 1;
		while (i > 0 && perm[i - 1] > perm[i])
			i--;
		if (i == 0)
			return false;

		// 2. i-1 ��ġ�� swap�� �ڸ� ã��
		int j = len - 1;
		while (perm[i - 1] > perm[j])
			j--;

		// 3. swap�ϱ�
		swap(perm, i - 1, j);

		// 4. �������� �ǳ����� �������� ����
		int k = len - 1;
		while (i < k)
			swap(perm, i++, k--);
		
		return true;
	}

	private static void swap(int[] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}

}
