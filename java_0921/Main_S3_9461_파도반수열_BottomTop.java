package java_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9461_파도반수열_BottomTop {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		long[] d = new long[101];

		// 1~3번째 파도반 수는 1, 4~5번째 파도반 수는 2
		d[1] = d[2] = d[3] = 1;
		d[4] = d[5] = 2;

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());

			// 파도반 함수를 반복문으로 구현 (보텀업 방식)
			for (int i = 6; i <= N; i++) {
				d[i] = d[i - 1] + d[i - 5];
			}

			System.out.println(d[N]);
		}
	}

}
