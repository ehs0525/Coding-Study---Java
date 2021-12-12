package java_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2470_두용액 {

	public static int N;
	public static int[] cv;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		cv = new int[N];

		StringTokenizer st  = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			cv[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cv); // 오름차순 정렬
		
		int acidic = 0, alkaline = N-1, closest = Integer.MAX_VALUE;
		int solution1 = acidic, solution2 = alkaline;
		while(acidic < alkaline) {
			int sum = cv[acidic] + cv[alkaline];
			if(Math.abs(sum) < closest) {
				solution1= acidic;
				solution2 = alkaline;
				closest = Math.abs(sum);
			}
			
			if(sum < 0) {
				acidic++;
			} else {
				alkaline--;
			}
		}
		
		sb.append(cv[solution1]).append(" ").append(cv[solution2]);
		System.out.println(sb);
	}

}
