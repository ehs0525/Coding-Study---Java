package java_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_10819_차이를최대로 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// N 입력받기
		N = Integer.parseInt(in.readLine());
		// 배열 A에 들어있는 정수 입력받기
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int max = Integer.MIN_VALUE;
		do {
			max = Integer.max(max, getValue(A));
		} while (np(A));

		System.out.println(max);

	}

	private static int getValue(int[] a) {
		int sum = 0;
		for (int i = 0; i < N - 1; i++)
			sum += Math.abs(a[i] - a[i + 1]);

		return sum;
	}

	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {

		int N = numbers.length;

		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1 위치값과 j 위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기(i)부터 맨뒤까지 내림차순 형태의 순열을 오름차순으로 처리
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
