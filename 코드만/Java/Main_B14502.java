package _0408;

import java.io.*;
import java.util.*;
//백준 14502 연구소
//1. 조합으로 0인 영역 3개를 선택하여 1로 바꿈
//2. bfs로 바이러스가 퍼질수 있는 곳 check
//3. 2에서 방문하지 않은 0의 개수 비교
public class Main_B14502 {
	static int n,m,answer,zCnt,vCnt,map[][],virus[][],zero[][];
	static boolean visited[],check[][];
	static int[]selected=new int[3];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	
	static void bfs() {
		check=new boolean[n][m];
		Queue<int[]>q=new LinkedList<>();
		for(int i=0;i<vCnt;i++) {
			q.add(virus[i]);
			check[virus[i][0]][virus[i][1]]=true;
		}
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&!check[nx][ny]&&map[nx][ny]==0) {
					check[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	static int getCnt() {
		int result=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!check[i][j]&&map[i][j]==0)result++;
			}
		}
		return result;
	}
	static void comb(int depth) {
		if(depth==3) {
			change(1);
			bfs();
			answer=Math.max(getCnt(), answer);
			change(0);
			return;
		}
		for(int i=depth;i<zCnt;i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[depth]=i;
				comb(depth+1);
				visited[i]=false;
			}
		}
	}
	static void change(int state) {
		for(int i:selected) {
			map[zero[i][0]][zero[i][1]]=state;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		zero=new int[n*m][2];
		virus=new int[10][2];
		zCnt=vCnt=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zero[zCnt++]=new int[]{i,j};
				else if(map[i][j]==2) virus[vCnt++] = new int[]{i,j};
			}
		}
		visited=new boolean[zCnt];
		comb(0);
		System.out.println(answer);
	}
}
