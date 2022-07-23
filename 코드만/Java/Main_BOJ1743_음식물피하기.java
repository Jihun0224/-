import java.io.*;
import java.util.*;

public class Main_BOJ1743_음식물피하기 {
	static int N,M,K,answer=0,dx[]={1,-1,0,0},dy[]= {0,0,1,-1};
	static boolean map[][];
	static void bfs(int i,int j) {
		Queue<int[]>q=new LinkedList<>();
		map[i][j]=false;
		q.add(new int[] {i,j});
		int res=1;
		while(!q.isEmpty()) {
			int[]now=q.poll();
			int x=now[0],y=now[1];
			for(int d=0;d<4;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<1||ny<1||nx>N||ny>M||!map[nx][ny])continue;
				q.add(new int[] {nx,ny});
				map[nx][ny]=false;
				res+=1;
			}
		}
		answer=Math.max(answer, res);
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		answer=0;
		map=new boolean[N+1][M+1];
		while(K-->0) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x][y]=true;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j])bfs(i,j);
			}
		}
		System.out.print(answer);
	}
}