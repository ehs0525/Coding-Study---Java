package java_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1946_신입사원 {

	public static class applicant implements Comparable<applicant> {
		int unassembled, interview;

		public applicant(int unassembled, int interview) {
			super();
			this.unassembled = unassembled;
			this.interview = interview;
		}

		@Override
		public int compareTo(applicant o) {
			return Integer.compare(this.unassembled, o.unassembled);
		}
	}

	public static int T, N;
	public static applicant[] applicants;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(in.readLine());
			applicants = new applicant[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int rank1 = Integer.parseInt(st.nextToken());
				int rank2 = Integer.parseInt(st.nextToken());
				applicants[i] = new applicant(rank1, rank2);
			}

			Arrays.sort(applicants);

			int count = 1, bestInterview = applicants[0].interview;
			for (int i = 1; i < N; i++) {
				if (applicants[i].interview < bestInterview) {
					count++;
					bestInterview = applicants[i].interview;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);

	}

}
