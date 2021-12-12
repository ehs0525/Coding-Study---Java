package java_1109;

import java.util.Arrays;

public class Main_S5_4673_¼¿ÇÁ³Ñ¹ö {

	static boolean[] isSelfNumber = new boolean[10000];

	public static void main(String[] args) {
		Arrays.fill(isSelfNumber, true);
		for (int i = 1; i < 10000; i++) {
			int n = i;
			int dn = n;
			while (n > 0) {
				dn += n % 10;
				n /= 10;
			}

			if (dn < 10000)
				isSelfNumber[dn] = false;
		}

		for (int i = 1; i < 10000; i++) {
			if (isSelfNumber[i]) {
				System.out.println(i);
			}
		}
	}

}
