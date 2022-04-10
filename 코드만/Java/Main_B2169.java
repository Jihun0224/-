package _0409;

import java.io.*;
import java.util.*;

public class Main_B2169 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] map=new int[n+1][m+1];
		int[][]dp=new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-999999999;
			}
		}
		
		for(int i=1;i<=m;i++) dp[1][i]=dp[1][i-1]+map[1][i];
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				int temp=dp[i-1][j];
				for(int k=j;k<=m;k++) {
					temp+=map[i][k];
					dp[i][k]=Math.max(dp[i][k], temp);
				}
				temp=dp[i-1][j];
				for(int k=j;k>0;k--) {
					temp+=map[i][k];
					dp[i][k]=Math.max(dp[i][k], temp);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
