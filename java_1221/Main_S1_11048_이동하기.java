package java_1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_11048_이동하기 {

	public static int N, M;
	public static int[][] maze, dp;
	
	public static int[] dx = {1,0,1};
	public static int[] dy = {0,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st= new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1;j<=M;j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				for(int k=0;k<3;k++) {
					int px = i - dx[k];
					int py = j - dy[k];
					
					dp[i][j] = Integer.max(dp[i][j], dp[px][py] + maze[i][j]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
