package java_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14719_ºø¹° {

	public static int H, W;
	public static boolean[][] blocks;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		blocks = new boolean[H][W];

		st = new StringTokenizer(in.readLine(), " ");
		for (int j = 0; j < W; j++) {
			int stacked = Integer.parseInt(st.nextToken());
			for (int i = H - 1; i > H - 1 - stacked; i--) {
				blocks[i][j] = true;
			}
		}

		int stagnant = 0;
		for (int i = 0; i < H; i++) {
			int walk = 0;
			while (walk < W) {
				if (blocks[i][walk]) {
					int block = walk;
					while (++walk < W && !blocks[i][walk])
						;
					if (walk < W) {
						stagnant += walk - block - 1;
					}
				} else {
					walk++;
				}
			}
		}

		System.out.println(stagnant);
	}

}
