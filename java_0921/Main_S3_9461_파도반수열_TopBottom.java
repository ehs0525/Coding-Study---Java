package java_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9461_파도반수열_TopBottom {

	// 한 번 계산된 결과를 메모이제이션하기 위한 배열 초기화
	public static long[] d = new long[101];

	// 파도반 함수를 재귀함수로 구현 (탑다운 방식)
	public static long padovan(int x) {
		// 종료 조건(1~3일 땐 1, 4~5일 땐 2를 반환)
		if (x <= 3)
			return 1;
		if (x <= 5)
			return 2;

		// 이미 계산한 적 있는 수열이라면 그대로 반환
		if (d[x] != 0)
			return d[x];

		// 아직 계산하지 않은 수열이라면 점화식에 따라서 파도반 결과 반환
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
