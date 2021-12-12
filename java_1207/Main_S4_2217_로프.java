package java_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_S4_2217_ทฮวม {

	public static int N, max = 0;
	public static Integer[] rope;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		rope = new Integer[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(rope, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		//Arrays.sort(rope, Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			max = Math.max(max, rope[i] * (i + 1));
		}

		System.out.println(max);
	}

}
