package java_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

	static int N, r, c, count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(z((int) Math.pow(2, N), r, c));
	}

	private static int z(int n, int x, int y) {
		if (n == 1)
			return 0;

		int mid = n / 2;
		if (x < mid && y < mid)
			return z(mid, x, y);
		if (x < mid && y >= mid)
			return mid * mid + z(mid, x, y - mid);
		if (x >= mid && y < mid)
			return 2 * mid * mid + z(mid, x - mid, y);
		// if (x >= mid && y >= mid)
		return 3 * mid * mid + z(mid, x - mid, y - mid);
	}

}
