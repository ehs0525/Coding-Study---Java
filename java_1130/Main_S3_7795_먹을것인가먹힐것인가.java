package java_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_7795_�������ΰ��������ΰ� {

	public static int T, N, M;
	public static int[] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// 1. B �迭 ������������ ����
			Arrays.sort(B);

			// 2. ��� A�� ���Ҹ��� B �迭�� ���� �̺� Ž�� ����
			// target �̸��� �� �� ���� ������ �ε����� ���ؾ� �Ѵ�.
//			int canEat = 0;
//			for (int i = 0; i < N; i++) {
//				int start = 0, end = M - 1, count = 0;
//				while (start <= end) {
//					int mid = (start + end) / 2;
//					if (B[mid] == A[i]) {
//						count = mid;
//						break;
//					} else if (B[mid] > A[i]) {
//						end = mid - 1;
//					} else {
//						start = mid + 1;
//						count = start;
//					}
//				}
//				canEat += count;
//			}

			int canEat = 0;
			for (int i = 0; i < N; i++) {
				int index = Arrays.binarySearch(B, A[i]);
				canEat += index >= 0 ? index : -index - 1;
			}

			System.out.println(canEat);
		}
	}

}
