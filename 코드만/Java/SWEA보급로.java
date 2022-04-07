package _0407;

import java.io.*;
import java.util.*;
//dp+bfs
public class SWEA보급로 {
	static int map[][],dp[][],n;
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static void bfs() {
		Queue<int[]>q=new LinkedList<>();
		//출발지 설정
		q.offer(new int[] {0,0});
		dp[0][0]=0;
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					//nx,ny까지 가는 거리가 짧아 질때, dp값 갱신해 주고 q에 추가
					if(dp[nx][ny]>dp[x][y]+map[nx][ny]) {
						dp[nx][ny]=dp[x][y]+map[nx][ny];
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			map=new int[n][n];
			dp=new int[n][n];
			for(int i=0;i<n;i++) {
				char[]temp=br.readLine().toCharArray();
				for(int j=0;j<n;j++) {
					map[i][j]=temp[j]-'0';
				}
			}
			//dp배열 초기화
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dp[i][j]=Integer.MAX_VALUE;
				}
			}
			bfs();
			sb.append("#"+t+" "+dp[n-1][n-1]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
