package java_0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_B2_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> line = new ArrayList<>();

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int len = line.size();
			int num = Integer.parseInt(st.nextToken());

			line.add(len - num, i);
		}

		for (int l : line)
			System.out.print(l + " ");
	}

}
