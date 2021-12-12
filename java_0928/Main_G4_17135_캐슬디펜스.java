package java_0928;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_17135_ĳ�����潺 {

	static class Enemy implements Comparable<Enemy> {
		Point p;

		public Enemy(Point p) {
			super();
			this.p = p;
		}

		@Override
		public int compareTo(Enemy o) {
			// �Ÿ��� ���� ��, ���ʿ� �ִ� ���� �����ϹǷ� y�� �������� ����
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

		archers = new int[M];	// �ü��� ��ġ(1�� ���� ��ġ)
		targets = new Enemy[3]; // �� �ü��� ��ǥ ��
		for (int i = M - targets.length; i < M; i++)
			archers[i] = 1;

		int max = 0;
		do {
			int count = 0; // �ü��� �������� ������ ���� ��

			// ���� ��ġ�� �����ϱ� ���� ����Ʈ ����
			reset();

			// ��� ���� ���ܵ� ������ ���� ����
			while (!enemies.isEmpty()) {
				// �� �ü��� Ÿ�� ã��
				aim();
				// �� Ÿ���� ���� ���ŵ��� �ʾҴٸ� �����ϰ� �� �� �߰��ϱ�
				count += attack();
				// ���� �Ʒ��� �� ĭ �̵���Ű��
				move();
			}
			// max�� �����ϱ�
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

	// ���� ū ������ ������ true, ������ false
	private static boolean np(int[] numbers) {

		int N = numbers.length;

		// step1. �����(i)�� ã�´�. ����⸦ ���� ��ȯ��ġ(i-1) ã��
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 ��ġ���� ��ȯ�� ū �� ã��
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1 ��ġ���� j ��ġ�� ��ȯ
		swap(numbers, i - 1, j);

		// step4. �����(i)���� �ǵڱ��� �������� ������ ������ ������������ ó��
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
