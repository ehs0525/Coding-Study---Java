package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// 집의 개수와 공유기의 개수 입력받기
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N];

		// 집의 좌표 입력받기
		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(in.readLine());
		Arrays.sort(x);

		int start = 1; // 가능한 최소 거리
		int end = x[N - 1] - x[0]; // 가능한 최대 거리
		int result = 0;

		while (start <= end) {
			// 가장 인접한 두 공유기 사이의 거리
			int mid = (start + end) / 2;

			// 첫번째 집은 무조건 설치
			int value = x[0];
			int cnt = 1;

			// 가장 인접한 공유기와의 거리가 mid 이상이라면 설치해보기
			for (int i = 1; i < N; i++) {
				if (x[i] - value >= mid) {
					value = x[i];
					cnt++;
				}
			}

			// C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시켜 개수를 줄이기
			if (cnt >= C) {
				start = mid + 1;
				result = mid; // 최적의 결과를 저장
			} else {
				end = mid - 1;
			}
		}

		System.out.println(result);
	}

}
