import java.io.*;
import java.util.*;

public class Main_B2573 {
	static int n,m,map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static boolean[][] visited;
	
	static void search() {
		int[][]temp=new int[n][m];
		int nx,ny;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]>0) {
					for(int d=0;d<4;d++) {
						nx=i+dx[d];
						ny=j+dy[d];
						if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]>0)continue;
						temp[i][j]++;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=Math.max(0, map[i][j]-temp[i][j]);
			}
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]>q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		int x,y,nx,ny,temp[];
		visited[i][j]=true;
		while(!q.isEmpty()) {
			temp=q.poll();
			x=temp[0];
			y=temp[1];
			for(int d=0;d<4;d++) {
				nx=x+dx[d];
				ny=y+dy[d];
				if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]==0||visited[nx][ny])continue;
				visited[nx][ny]=true;
				q.offer(new int[] {nx,ny});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int answer=0,cnt;
		while(true) {
			answer++;
			cnt=0;
			visited=new boolean[n][m];
			search();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]>0&&!visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			if(cnt==0||cnt>1) {
				if(cnt==0)answer=0;
				break;
			}
		}
		System.out.println(answer);
	}
}
