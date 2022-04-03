import java.io.*;
import java.util.*;
//백준 4485 녹색 옷 입은 애가 젤다지? ->bfs, dp
public class Main_B4485 {
	static int n,map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	//bfs
	static int bfs() {
		Queue<int[]>q=new LinkedList<>();
		q.offer(new int[] {0,0});
		int[][]dp=new int[n][n];
		//모든 지점을 max값으로 초기화
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		//출발 지점을 초기화
		dp[0][0]=map[0][0];
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				//맵 범위 안인지 체크
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					//현재지점까지 오는데 더 짧은 가중치를 체크
					if(dp[nx][ny]>dp[x][y]+map[nx][ny]) {
						dp[nx][ny]=dp[x][y]+map[nx][ny];
						q.offer(new int[] {nx,ny});
					}
				}
			}
			
		}
		return dp[n-1][n-1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		while(true) {
		n = Integer.parseInt(br.readLine());
		if(n==0)break;
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println("Problem "+t+++": "+bfs());
		}
	}
}
