package java_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_1541_ÀÒ¾î¹ö¸°°ýÈ£ {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<String> chunks = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		while (st.hasMoreTokens()) {
			chunks.add(st.nextToken());
		}

		int answer = add(chunks.get(0));
		for (int i = 1; i < chunks.size(); i++) {
			answer -= add(chunks.get(i));
		}
		System.out.println(answer);
	}

	public static int add(String equation) {
		int sum = 0;

		StringTokenizer st = new StringTokenizer(equation, "+");
		while (st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}

		return sum;
	}

}
