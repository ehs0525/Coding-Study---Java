package java_0928;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_17135_캐슬디펜스 {

	static class Enemy implements Comparable<Enemy> {
		Point p;

		public Enemy(Point p) {
			super();
			this.p = p;
		}

		@Override
		public int compareTo(Enemy o) {
			// 거리가 같을 때, 왼쪽에 있는 적을 공격하므로 y로 오름차순 정렬
			return Integer.compare(this.p.y, o.p.y);
		}

	}

	static int N, M, D;
	static int[] archers;
	static Enemy[] targets;
	static int[][] grid;
	static ArrayList<Enemy> enemies = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		archers = new int[M];	// 궁수의 위치(1인 곳에 배치)
		targets = new Enemy[3]; // 각 궁수의 목표 적
		for (int i = M - targets.length; i < M; i++)
			archers[i] = 1;

		int max = 0;
		do {
			int count = 0; // 궁수의 공격으로 제거한 적의 수

			// 적의 위치를 관리하기 위한 리스트 생성
			reset();

			// 모든 적이 제외될 때까지 게임 진행
			while (!enemies.isEmpty()) {
				// 각 궁수의 타겟 찾기
				aim();
				// 그 타겟이 아직 제거되지 않았다면 공격하고 그 수 추가하기
				count += attack();
				// 적을 아래로 한 칸 이동시키기
				move();
			}
			// max값 갱신하기
			max = Integer.max(max, count);

		} while (np(archers));

		System.out.println(max);
	}

	private static void move() {
		for (int i = 0; i < enemies.size(); i++) {
			if (++enemies.get(i).p.x == N) {
				enemies.remove(i);
				i--;
			}
		}
	}

	private static int attack() {
		int removed = 0;
		for (Enemy target : targets) {
			if (enemies.remove(target)) {
				removed++;
			}
		}
		return removed;
	}

	private static void aim() {
		Collections.sort(enemies);

		for (int i = 0, index = 0; i < M; i++) {
			int min = Integer.MAX_VALUE;
			if (archers[i] == 1) {
				Enemy target = null;
				for (Enemy enemy : enemies) {
					int dist = Math.abs(N - enemy.p.x) + Math.abs(i - enemy.p.y);
					if (dist <= D && dist < min) {
						target = enemy;
						min = dist;
					}
				}
				targets[index++] = target;
			}
		}
	}

	private static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 1) {
					enemies.add(new Enemy(new Point(i, j)));
				}
			}
		}
	}

	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {

		int N = numbers.length;

		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1 위치값과 j 위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기(i)부터 맨뒤까지 내림차순 형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;

	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
