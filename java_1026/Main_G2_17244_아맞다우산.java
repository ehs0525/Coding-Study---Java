package java_1026;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17244_�Ƹ´ٿ�� {

	static int N, M, dist = 0;
	static char[][] house;
	static Point s, e;
	static ArrayList<Point> x = new ArrayList<>();
	
	static int[] dx = {1,-1,0,0};
	static int[] dy= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new char[M][N];

		int count = 0;
		for (int i = 0; i < M; i++) {
			house[i] = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (house[i][j] == 'S') {
					s = new Point(i, j);
				} else if (house[i][j] == 'E') {
					e = new Point(i, j);
				} else if (house[i][j] == 'X') {
					x.add(new Point(i, j));
				}
			}
		}
		int[] p = new int[x.size()];
		for(int i=0;i<x.size();i++) {
			p[i] = i;
		}
		
		do {
			
			packThings(p);
			
		} while(np(p));

	}

	private static void packThings(int[] p) {
		int[][] visited = new int[M][N];
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(s);
		
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
