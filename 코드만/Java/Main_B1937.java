package _0408;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B1937 {
	static int n,answer,arr[][],dp[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,-1,1};
	static int dfs(int x,int y) {
		if(dp[x][y]==0) {
			dp[x][y]=1;
			int depth=0;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<n&&arr[nx][ny]>arr[x][y]) {
					depth=Math.max(depth, dfs(nx,ny));
				}
			}
			dp[x][y]+=depth;
		}
		return dp[x][y];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		dp=new int[n][n];
		answer=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				answer=Math.max(answer, dfs(i,j));
			}
		}
		System.out.println(answer);
	}
}