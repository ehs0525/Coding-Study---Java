package java_0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17471_게리맨더링 {

	public static int N, min = Integer.MAX_VALUE;
	public static int[] population;
	public static boolean[] isSelected, visited;
	// 행이 (N+1)개인 인접 리스트 표현
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

		// 그래프 초기화
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 각 구역에 연결된 구역 번호 저장
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

	// 선거구를 나누기 위한 부분집합 함수
	private static void gerrymander(int index) {
		if (index == N + 1) {
			if (isPossible()) { // 가능한 방법이라면
				min = Integer.min(min, getPopDiff()); // 인구 차이의 최소값 갱신
			}

			return;
		}

		// 현재 구역을 부분집합에 넣기
		isSelected[index] = true;
		gerrymander(index + 1);
		// 현재 구역을 부분집합에 넣지 않기
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

	// 가능한 방법인지 확인하는 함수
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

	// 각 선거구에 포함된 구역이 서로 연결되어 있는지 확인하기 위한 bfs 함수
	private static void bfs(ArrayList<Integer> cons) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(cons.get(0));
		visited[cons.get(0)] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < graph.get(curr).size(); i++) {
				int next = graph.get(curr).get(i);
				if (isSelected[curr] == isSelected[next]) { // 같은 선거구일 때만 진행
					if (!visited[next]) {
						q.offer(next);
						visited[next] = true;
					}
				}
			}
		}

	}

}
