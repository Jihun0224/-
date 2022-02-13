package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
	
	static int[][]map;
	static int N,M;
	static int answer;
	
	static void bfs() {
		int[][] d= {{1,0},{0,1},{-1,0},{0,-1}};
		int x,y,nx,ny,temp[],can;
		int[][][] visited = new int[N][M][2];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{0,0,1});
		visited[0][0][1]=1;
		while(!q.isEmpty()) {
			temp = q.poll();
			x=temp[0];y=temp[1];can=temp[2];
			if(x==N-1&&y==M-1) {
				System.out.println(visited[x][y][can]);
				return;
			}
			for(int i=0;i<4;i++) {
	            nx=x+d[i][0];
	            ny=y+d[i][1];
	            
	            if(nx>=0&& nx<N&&ny>=0&&ny<M){
	            	if(map[nx][ny]==1&&can==1) {
	            		visited[nx][ny][0]=visited[x][y][1]+1;
	            		q.offer(new int[]{nx,ny,0});
	            	}
	            	else if(map[nx][ny]==0&&visited[nx][ny][can]==0) {
	            		visited[nx][ny][can]=visited[x][y][can]+1;
	            		q.offer(new int[]{nx,ny,can});
	            	}
	            }
			}
		}
		System.out.println(-1);
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		answer=N*M;
		char[] temp;
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			temp=br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j]=(int)temp[j]-48;
			}
		}
		
		bfs();
		
	}
}
