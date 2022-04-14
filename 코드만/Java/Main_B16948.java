package _0414;

import java.io.*;
import java.util.*;

public class Main_B16948 {
	static int N,start[],end[];
	static int[]dx= {-2,-2,0,0,2,2};
	static int[]dy= {-1,1,-2,2,-1,1};
	static int bfs() {
		int depth=-1;
		boolean[][]visited = new boolean[N][N];
		Queue<int[]>q=new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			depth++;
			for(int k=0;k<size;k++) {
				int[]temp=q.poll();
				int x=temp[0],y=temp[1];
				if(x==end[0]&&y==end[1])return depth;
				for(int i=0;i<6;i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		start=new int[2];
		end=new int[2];
		start[0]=Integer.parseInt(st.nextToken());
		start[1]=Integer.parseInt(st.nextToken());
		end[0]=Integer.parseInt(st.nextToken());
		end[1]=Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
}
