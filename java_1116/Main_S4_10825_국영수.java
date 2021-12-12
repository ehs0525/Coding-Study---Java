package java_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_10825_국영수 {

	static class Student implements Comparable<Student> {
		String name;
		int korean;
		int english;
		int math;

		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			// 1. 국어 점수가 감소하는 순서로
			if (this.korean != o.korean) {
				return Integer.compare(o.korean, this.korean);
			} else {
				if (this.english != o.english) { // 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
					return Integer.compare(this.english, o.english);
				} else {
					if (this.math != o.math) { // 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
						return Integer.compare(o.math, this.math);
					} else { // 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
						return this.name.compareTo(o.name);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		Student[] students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			students[i] = new Student(name, korean, english, math);
		}

		Arrays.sort(students);
		for (int i = 0; i < N; i++) {
			System.out.println(students[i].name);
		}
	}

}
