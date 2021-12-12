package java_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			Stack<Character> s = new Stack<>();
			String str = in.readLine();

			if (str.equals("."))
				break;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					s.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (!s.isEmpty() && s.peek() == '(') {
						s.pop();
					} else {
						s.push(str.charAt(i));
					}
				} else if (str.charAt(i) == ']') {
					if (!s.isEmpty() && s.peek() == '[') {
						s.pop();
					} else {
						s.push(str.charAt(i));
					}
				}
			}

			if (s.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		System.out.println(sb);
	}

}
