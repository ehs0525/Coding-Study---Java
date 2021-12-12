package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 나무의 수와 상근이가 집으로 가져가려고 하는 나무의 길이 입력받기
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 나무의 높이 입력받기
		int[] tree = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(st.nextToken());

		// 이진 탐색을 위한 시작점과 끝점 설정
		int start = 0;
		int end = Integer.MAX_VALUE;

		// 이진 탐색 수행
		int result = 0;
		while (start <= end) {
			long cut_off = 0; // overflow 방지를 위해 int가 아닌 long형으로 선언
			int mid = (start + end) / 2;

			// 상근이가 들고 집에 갈 나무의 길이
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid)
					cut_off += tree[i] - mid;
			}

			// 나무의 길이가 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
			if (cut_off < M) {
				end = mid - 1;
			}
			// 나무의 길이가 충분한 경우 덜 자르기(오른쪽 부분 탐색)
			else {
				start = mid + 1;
				result = mid;
			}
		}

		System.out.println(result);

	}

}
