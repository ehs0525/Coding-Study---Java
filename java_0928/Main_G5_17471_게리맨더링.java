package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17471_�Ը��Ǵ��� {

	public static int N, min = Integer.MAX_VALUE;
	public static int[] population;
	public static boolean[] isSelected, visited;
	// ���� (N+1)���� ���� ����Ʈ ǥ��
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> red, blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		population = new int[N + 1];
		isSelected = new boolean[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// �׷��� �ʱ�ȭ
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// �� ������ ����� ���� ��ȣ ����
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num);
			}
		}

		gerrymander(1);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	// ���ű��� ������ ���� �κ����� �Լ�
	private static void gerrymander(int index) {
		if (index == N + 1) {
			if (isPossible()) { // ������ ����̶��
				min = Integer.min(min, getPopDiff()); // �α� ������ �ּҰ� ����
			}

			return;
		}

		// ���� ������ �κ����տ� �ֱ�
		isSelected[index] = true;
		gerrymander(index + 1);
		// ���� ������ �κ����տ� ���� �ʱ�
		isSelected[index] = false;
		gerrymander(index + 1);
	}

	private static int getPopDiff() {
		int redPop = 0, bluePop = 0;

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				redPop += population[i];
			} else {
				bluePop += population[i];
			}
		}

		return Math.abs(redPop - bluePop);
	}

	// ������ ������� Ȯ���ϴ� �Լ�
	private static boolean isPossible() {
		red = new ArrayList<Integer>();
		blue = new ArrayList<Integer>();
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				red.add(i);
			} else {
				blue.add(i);
			}
		}

		if (red.isEmpty() || blue.isEmpty())
			return false;

		bfs(red);
		bfs(blue);
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	// �� ���ű��� ���Ե� ������ ���� ����Ǿ� �ִ��� Ȯ���ϱ� ���� bfs �Լ�
	private static void bfs(ArrayList<Integer> cons) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(cons.get(0));
		visited[cons.get(0)] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < graph.get(curr).size(); i++) {
				int next = graph.get(curr).get(i);
				if (isSelected[curr] == isSelected[next]) { // ���� ���ű��� ���� ����
					if (!visited[next]) {
						q.offer(next);
						visited[next] = true;
					}
				}
			}
		}

	}

}
