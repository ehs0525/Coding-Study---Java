package java_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {

	public static int W;
	public static int[] buildings;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			W = Integer.parseInt(in.readLine());
			buildings = new int[W];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int i = 0; i < W; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 0; i < W; i++) {
				int tallest = findTallestNearby(i);
				if (buildings[i] > tallest) {
					count += buildings[i] - tallest;
				}
			}

			sb.append("#").append(t).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}

	// 좌우 2칸 내 가장 높은 빌딩의 높이를 반환
	private static int findTallestNearby(int building) {
		int max = 0;
		int[] di = { -2, -1, 1, 2 };

		for (int i = 0; i < 4; i++) {
			int ni = building + di[i];

			if (0 <= ni && ni < W) {
				max = Math.max(max, buildings[ni]);
			}
		}

		return max;
	}

}
