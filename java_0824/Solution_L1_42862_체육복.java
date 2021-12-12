package java_0824;

import java.util.Arrays;

public class Solution_L1_42862_ü���� {

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
		// ü������ �ְų� �������� true, ���ų� ���� ������ �������� false
		for (int i = 0; i < lnum; i++)
			borrowed[lost[i]] = false;
		// �̹� �����־��ų� ������ ������ true, ������ ���� �������� �ʾ����� false
		for (int i = 0; i < rnum; i++)
			lent[reserve[i]] = false;

		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// �ʱ� ���� : n-lnum ��ŭ�� ü�������� ���� �� �ִ�.
		n -= lnum;

		/*// ���� ü������ ������ �л��� ü������ ���������� ���
		for (int i = 0; i < lnum; i++) {
			if (!lent[lost[i]]) {
				n++;
				borrowed[lost[i]] = true;
				lent[lost[i]] = true;
			}
		}

		// ü������ �������� �л��� ���Ͽ� �չ�ȣ �л����� ������
		for (int i = 0; i < lnum; i++) {
			if (lost[i] > 1 && !borrowed[lost[i]] && !lent[lost[i] - 1]) {
				n++;
				borrowed[lost[i]] = true;
				lent[lost[i] - 1] = true;
			}
		}

		// ü������ �������� �л��� ���Ͽ� �޹�ȣ �л����� ������
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
