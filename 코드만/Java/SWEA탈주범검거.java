package _0407;

import java.io.*;
import java.util.*;
//bfs+dp
public class SWEA탈주범검거 {
	static int answer,n,m,r,c,l,map[][],dp[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};

	static int bfs() {
		Queue<int[]>q=new LinkedList<>();
		//출발지 초기화
		dp[r][c]=1;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			if(dp[x][y]!=Integer.MAX_VALUE&&dp[x][y]>=l)continue;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!=0) {
					boolean flag=false;
					int cur=map[x][y];
					int next=map[nx][ny];
					//각 탐색 방향에 따라 이어져 있는 경우만 이동
					switch (i) {
					//아래로 이동할 때
					case 0:
						if(cur==1||cur==2||cur==5||cur==6) {
							if(next==1||next==2||next==4||next==7) {
								flag=true;
							}
						}
						break;
					//위로 이동할 때
					case 1:
						if(cur==1||cur==2||cur==4||cur==7) {
							if(next==1||next==2||next==5||next==6) {
								flag=true;
							}
						}
						break;
					//오른쪽으로 이동할 때
					case 2:
						if(cur==1||cur==3||cur==4||cur==5) {
							if(next==1||next==3||next==6||next==7) {
								flag=true;
							}
						}
						break;
					//왼쪽으로 이동할 때
					case 3:
						if(cur==1||cur==3||cur==6||cur==7) {
							if(next==1||next==3||next==4||next==5) {
								flag=true;
							}
						}
						break;
					}
					//이동가능한 위치이고, nx,ny로 가는데 걸리는 시간이 짧아지는 경우에만 q에 add
					if(flag&&dp[nx][ny]>dp[x][y]+1) {
						dp[nx][ny]=dp[x][y]+1;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		//갈 수 있는 위치를 구함 
		int result=0;
		for(int[]a:dp) {
			for(int i:a) {
				if(i<=l)result++;
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			map=new int[n][m];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//=========입력==========
			
			//dp초기화
			dp=new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					dp[i][j]=Integer.MAX_VALUE;
				}
			}		
			sb.append("#"+t+" "+bfs()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
