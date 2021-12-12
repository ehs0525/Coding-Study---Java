package java_0831;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2564_경비원 {

	static int W, H;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(in.readLine());
		Point[] store = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			store[i] = new Point(dir, dist);
		}

		st = new StringTokenizer(in.readLine(), " ");
		int dir = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		Point donggeun = new Point(dir, dist);

		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += getMinDistance(donggeun, store[i]);

		System.out.println(sum);

	}

	private static int getMinDistance(Point p1, Point p2) {
		if (p1.x == p2.x) { // 두 점이 같은 선상에 있을 때 (4가지)
			return Math.abs(p2.y - p1.y);
		} else if ((p1.x == 1 && p2.x == 3) || (p1.x == 3 && p2.x == 1)) { // ┌ 모양일 때 (2가지)
			return p1.y + p2.y;
		} else if ((p1.x == 1 && p2.x == 4) || (p1.x == 4 && p2.x == 1)) { // ┐ 모양일 떄 (2가지)
			if (p1.x == 1) {
				return (W - p1.y) + p2.y;
			} else {
				return (W - p2.y) + p1.y;
			}
		} else if ((p1.x == 2 && p2.x == 3) || (p1.x == 3 && p2.x == 2)) { // └ 모양일 때 (2가지)
			if (p1.x == 2) {
				return p1.y + (H - p2.y);
			} else {
				return p2.y + (H - p1.y);
			}
		} else if ((p1.x == 2 && p2.x == 4) || (p1.x == 4 && p2.x == 2)) { // ┘ 모양일 때 (2가지)
			return (W - p1.y) + (H - p2.y); // 반대 경우도 똑같다
		} else if ((p1.x == 1 && p2.x == 2) || (p1.x == 2 && p2.x == 1)) { // = 모양일 때 (2가지)
			int dist1 = p1.y + p2.y + H;
			int dist2 = 2 * (W + H) - dist1;

			return Math.min(dist1, dist2);
		} else { // || 모양일 때 (2가지)
			int dist1 = p1.y + p2.y + W;
			int dist2 = 2 * (W + H) - dist1;

			return Math.min(dist1, dist2);
		}
	}

}
