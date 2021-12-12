package java_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1169_주사위던지기1 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		throwDice(0, N);
	}

	private static void throwDice(int lev, int mode) {
		
		switch (mode) {
		case 1:
			if(lev==3)
				break;
			
			for(int i=1;i<=6;i++) {
				System.out.println(i + " ");
				throwDice(lev + 1, mode);
			}
			
			break;

		case 2:

			break;
		case 3:

			break;
		default:
			break;
		}

	}

}
