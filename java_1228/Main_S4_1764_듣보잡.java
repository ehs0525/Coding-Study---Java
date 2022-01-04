package java_1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1764_µË∫∏¿‚ {

	public static int N, M;
	public static String[] neverHeardOf, neverSeen;
	public static ArrayList<String> dbjs = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		neverHeardOf = new String[N];
		neverSeen = new String[M];

		for (int i = 0; i < N; i++) {
			neverHeardOf[i] = in.readLine();
		}
		for (int j = 0; j < M; j++) {
			neverSeen[j] = in.readLine();
		}

		Arrays.sort(neverHeardOf);
		Arrays.sort(neverSeen);

		for (int i = 0; i < M; i++) {
			if (Arrays.binarySearch(neverHeardOf, neverSeen[i]) >= 0) {
				dbjs.add(neverSeen[i]);
			}
		}

		System.out.println(dbjs.size());
		for (String dbj : dbjs) {
			System.out.println(dbj);
		}
	}

}
