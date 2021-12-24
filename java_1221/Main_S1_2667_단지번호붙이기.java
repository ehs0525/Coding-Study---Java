package java_1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_S1_2667_단지번호붙이기 {

	public static int N, house; // house : 각 단지내 집의 수
	public static int[][] map;
	public static ArrayList<Integer> housesInComplex = new ArrayList<>();

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = line[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				house = 0;
				if (dfs(i, j)) {
					housesInComplex.add(house);
				}
			}
		}

		System.out.println(housesInComplex.size());
		Collections.sort(housesInComplex);
		for(int house : housesInComplex) {
			System.out.println(house);
		}
	}

	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		if (map[x][y] > 0) {
			map[x][y] = 0;
			house++;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				dfs(nx, ny);
			}
			return true;
		}

		return false;
	}
}
