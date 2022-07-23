import java.util.*;
import java.io.*;
public class Main_BOJ1926_그림{
	static int n,m,answer,map[][];
	static boolean visited[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static void bfs(int i,int j) {
		int tmp=1;
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j]=true;
		while(!q.isEmpty()) {
			int[]now=q.poll();
			int x=now[0],y=now[1];
			for(int d=0;d<4;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<0 || nx>=n||ny<0||ny>=m||visited[nx][ny])continue;
				visited[nx][ny]=true;
				if(map[nx][ny]==0)continue;
				q.add(new int[] {nx,ny});
				tmp+=1;
			}
		}
		answer=Math.max(answer, tmp);
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		answer=0;
		int depth=0;
		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					depth+=1;
					bfs(i,j);
				}
			}
		}
		System.out.println(depth+"\n"+answer);
	}
}
