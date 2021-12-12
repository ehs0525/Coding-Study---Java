package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2805_�����ڸ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// ������ ���� ����̰� ������ ���������� �ϴ� ������ ���� �Է¹ޱ�
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// ������ ���� �Է¹ޱ�
		int[] tree = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(st.nextToken());

		// ���� Ž���� ���� �������� ���� ����
		int start = 0;
		int end = Integer.MAX_VALUE;

		// ���� Ž�� ����
		int result = 0;
		while (start <= end) {
			long cut_off = 0; // overflow ������ ���� int�� �ƴ� long������ ����
			int mid = (start + end) / 2;

			// ����̰� ��� ���� �� ������ ����
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid)
					cut_off += tree[i] - mid;
			}

			// ������ ���̰� ������ ��� �� ���� �ڸ���(���� �κ� Ž��)
			if (cut_off < M) {
				end = mid - 1;
			}
			// ������ ���̰� ����� ��� �� �ڸ���(������ �κ� Ž��)
			else {
				start = mid + 1;
				result = mid;
			}
		}

		System.out.println(result);

	}

}
