import java.beans.Visibility;
import java.io.*;
import java.util.*;

public class Main_14716 {
	static int M,N,arr[][];
	static int dx[]= {1,-1,0,0,1,1,-1,-1};
	static int dy[]= {0,0,1,-1,1,-1,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new int[M][N];
		visited=new boolean[M][N];
		int answer=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&arr[i][j]==1) {
					answer++;
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	static void bfs(int i,int j) {
		Queue<int[]>q=new LinkedList<>();
		visited[i][j]=true;
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[]now=q.poll();
			int x=now[0];
			int y=now[1];
			for(int d=0;d<8;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<0||ny<0||nx>=M||ny>=N||arr[nx][ny]==0||visited[nx][ny])continue;
				visited[nx][ny]=true;
				q.add(new int[] {nx,ny});
			}
		}
	}
}
