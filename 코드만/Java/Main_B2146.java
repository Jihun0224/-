package _0417;

import java.io.*;
import java.util.*;

public class Main_B2146 {
	static int N,map[][],answer;
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static void bfs(int group) {
		Queue<int[]>q=new LinkedList<>();
		int[][]dist=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==group) 
					q.add(new int[] {i,j});
				else dist[i][j]=-1;
			}
		}
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			for(int d=0;d<4;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<0||nx>=N||ny<0||ny>=N)continue;
				if(map[nx][ny]>0&&map[nx][ny]!=group) {
					answer=Math.min(answer, dist[x][y]);
					return;
				}
				if(map[nx][ny]==0&&dist[nx][ny]==-1) {
					dist[nx][ny]=dist[x][y]+1;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	static void clustering(boolean[][]visited,int group,int x,int y) {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		map[x][y]=group;
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			x=temp[0];
			y=temp[1];
			for(int d=0;d<4;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<0||nx>=N||ny<0||ny>=N||map[nx][ny]==0||visited[nx][ny])continue;
				map[nx][ny]=group;
				visited[nx][ny]=true;
				q.add(new int[] {nx,ny});
			}
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		boolean[][]visited=new boolean[N][N];
		int group=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					clustering(visited,group,i,j);
					group++;
				}
			}
		}
		for(int i=1;i<group;i++) bfs(i);
		System.out.println(answer);
	}
}
