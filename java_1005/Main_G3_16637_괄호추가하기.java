package java_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G3_16637_괄호추가하기 {

	static int N, max = Integer.MIN_VALUE;
	static int[] nums;
	static char[] ops;
	static boolean[] isAdded;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		String equation = in.readLine();

		nums = new int[N / 2 + 1];
		ops = new char[N / 2];
		isAdded = new boolean[N / 2];
		for (int i = 0; i < N; i++) {
			char c = equation.charAt(i);
			if ('0' <= c && c <= '9') {
				nums[i / 2] = c - '0';
			} else {
				ops[i / 2] = c;
			}
		}

		if (N >= 2) {
			addParentheses(0, 0);
		} else {
			max = nums[0];
		}
		System.out.println(max);
	}

	// 추가할 괄호를 정하여 연산하기 위한 부분집합 함수
	private static void addParentheses(int index, int result) {
		if (index >= N / 2) {
			if (!isAdded[N / 2 - 1]) {
				result = operate(result, ops[N / 2 - 1], nums[N / 2]);
			}
			max = Integer.max(max, result);
			return;
		}

		// 현재 괄호를 수식에 추가하기
		isAdded[index] = true;
		int res1 = operate(nums[index], ops[index], nums[index + 1]);
		if (index > 0) {
			res1 = operate(result, ops[index - 1], res1);
		}
		addParentheses(index + 2, res1);

		// 현재 괄호를 수식에 추가하지 않기
		isAdded[index] = false;
		int res2 = nums[index];
		if (index > 0) {
			res2 = operate(result, ops[index - 1], res2);
		}
		addParentheses(index + 1, res2);
	}

	private static int operate(int num1, char op, int num2) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		default:
			return 0;
		}
	}

}
