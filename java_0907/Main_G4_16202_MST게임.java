package java_0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_16202_MST���� {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = graph[y][x] = i;
		}

		for (int i = 0; i < K; i++) {
			int tx = 0, ty = 0;
			int target = Integer.MAX_VALUE; // ������ ������ ����ġ
			boolean[] visited = new boolean[N + 1];
			int[] minEdge = new int[N + 1];
			for (int j = 1; j <= N; j++)
				minEdge[j] = Integer.MAX_VALUE;

			int result = 0;
			minEdge[1] = 0;

			for (int j = 0; j < N; j++) {
				// 1. ����Ʈ���� ���Ե��� ���� ���� �� �ּҰ�������� ���� ã��
				int min = Integer.MAX_VALUE;
				int minVertex = -1; // �ּҰ�������� ������ȣ
				for (int k = 1; k <= N; k++) {
					if (!visited[k] && min > minEdge[k]) {
						min = minEdge[k];
						minVertex = k;
					}
				}

				if (min == Integer.MAX_VALUE) {
					result = 0;
					break;
				}

				visited[minVertex] = true; // ����Ʈ���� ���Խ�Ŵ
				result += min; // ������� ����

				// 2. ���õ� ���� �������� ����Ʈ���� ������� ���� Ÿ �������� ���� ��� �ּҷ� ������Ʈ
				for (int k = 1; k <= N; k++) {
					if (!visited[k] && graph[minVertex][k] != 0 && minEdge[k] > graph[minVertex][k]) {
						minEdge[k] = graph[minVertex][k];

						// ���� MST���� ����ġ�� ���� ���� ���� ���ϱ�
						if (target > graph[minVertex][k]) {
							tx = minVertex;
							ty = k;
							target = graph[minVertex][k];
						}
					}
				}
			}

			graph[tx][ty] = graph[ty][tx] = 0;
			System.out.print(result + " ");
		}
	}

}
