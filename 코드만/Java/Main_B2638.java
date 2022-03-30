import java.io.*;
import java.util.*;
// 백준 치즈 -> bfs
public class Main_B2638 {
	static int r,c,map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static int bfs() {
		int cnt=0;
		boolean[][] visited=new boolean[r][c];
		Queue<int[]>q = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		visited[0][0]=true;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]==1)cnt++;
			}
		}
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			for(int i=0;i<4;i++) {
				int nx=temp[0]+dx[i];
				int ny=temp[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<r&&ny<c&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					if(map[nx][ny]==0)q.add(new int[] {nx,ny});
					else map[nx][ny]=-1;
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]==-1)map[i][j]=0;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		map=new int[r][c];
		int cnt=-1,hour=0,pre=0;
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(cnt!=0) {
			cnt=bfs();
			if(cnt!=0) {
				pre=cnt;
				hour++;
			}
		}
		System.out.println(hour);
		System.out.println(pre);
	}
}
