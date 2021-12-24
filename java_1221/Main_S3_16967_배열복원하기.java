package java_1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_16967_배열복원하기 {

	public static int H, W, X, Y;
	public static int[][] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		A = new int[H][W];
		B = new int[H + X][W + Y];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W + Y; j++) {
				if (i >= H || j >= W)
					break;

				if (i < X || j < Y) {
					A[i][j] = Integer.parseInt(st.nextToken());
				} else {
					A[i][j] = Integer.parseInt(st.nextToken()) - A[i - X][j - Y];
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}
