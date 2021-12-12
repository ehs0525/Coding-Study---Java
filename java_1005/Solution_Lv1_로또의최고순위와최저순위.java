package java_1005;

import java.util.Arrays;

public class Solution_Lv1_로또의최고순위와최저순위 {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 })));
		System.out.println(
				Arrays.toString(solution(new int[] { 0, 0, 0, 0, 0, 0 }, new int[] { 38, 19, 20, 40, 15, 25 })));
		System.out.println(
				Arrays.toString(solution(new int[] { 45, 4, 35, 20, 3, 9 }, new int[] { 20, 9, 3, 45, 4, 35 })));
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int match = 0, unrecog = 0;

		Arrays.sort(win_nums);
		for (int lotto : lottos) {
			if (Arrays.binarySearch(win_nums, lotto) >= 0) {
				match++;
			} else if (lotto == 0) {
				unrecog++;
			}
		}

		answer[0] = rankLottery(match + unrecog);
		answer[1] = rankLottery(match);

		return answer;
	}

	private static int rankLottery(int match) {
		switch (match) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}

}
