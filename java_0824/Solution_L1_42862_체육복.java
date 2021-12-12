package java_0824;

import java.util.Arrays;

public class Solution_L1_42862_체육복 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 })); // 5
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 })); // 4
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 })); // 2
		System.out.println(solution(3, new int[] { 1, 2 }, new int[] { 2, 3 })); // 2
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3, 1 })); // 5
		System.out.println(solution(10, new int[] { 8,10 }, new int[] { 6,7,9 })); // 10
		
		

	}

	private static int solution(int n, int[] lost, int[] reserve) {
		int lnum = lost.length;
		int rnum = reserve.length;
		boolean[] borrowed = new boolean[n + 1];
		boolean[] lent = new boolean[n + 1];

		for (int i = 1; i <= n; i++)
			borrowed[i] = lent[i] = true;
		// 체육복이 있거나 빌렸으면 true, 없거나 아직 빌리지 못했으면 false
		for (int i = 0; i < lnum; i++)
			borrowed[lost[i]] = false;
		// 이미 빌려주었거나 여벌이 없으면 true, 있지만 아직 빌려주지 않았으면 false
		for (int i = 0; i < rnum; i++)
			lent[reserve[i]] = false;

		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// 초기 상태 : n-lnum 명만큼만 체육수업을 들을 수 있다.
		n -= lnum;

		/*// 여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우
		for (int i = 0; i < lnum; i++) {
			if (!lent[lost[i]]) {
				n++;
				borrowed[lost[i]] = true;
				lent[lost[i]] = true;
			}
		}

		// 체육복을 도난당한 학생에 한하여 앞번호 학생에게 빌리기
		for (int i = 0; i < lnum; i++) {
			if (lost[i] > 1 && !borrowed[lost[i]] && !lent[lost[i] - 1]) {
				n++;
				borrowed[lost[i]] = true;
				lent[lost[i] - 1] = true;
			}
		}

		// 체육복을 도난당한 학생에 한하여 뒷번호 학생에게 빌리기
		for (int i = 0; i < lnum; i++) {
			if (lost[i] < n && !borrowed[lost[i]] && !lent[lost[i] + 1]) {
				n++;
				borrowed[lost[i]] = true;
				lent[lost[i] + 1] = true;
			}
		}*/
		
		for(int i=0;i <lnum;i++) {
			if(!lent[lost[i]]) {
				n++;
			//	borrowed[lost[i]] = true;
				lent[lost[i]]=true;
			} else if(lost[i] > 1 && !lent[lost[i] - 1]) {
				n++;
			//	borrowed[lost[i]] = true;
				lent[lost[i] -1]=true;
			} else if(lost[i] < n && !lent[lost[i] + 1]) {
				n++;
			//	borrowed[lost[i]] = true;
				lent[lost[i] + 1] = true;
			}
		}

		return n;

	}

}
