import java.io.*;
import java.util.*;
public class Main_BOJ20058_마법사상어와파이어스톰 {
	static int N,Q,arr[][],L,answer,total;
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static boolean[][]visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while(Q-->0) {
			L=(int)Math.pow(2, Integer.parseInt(st.nextToken()));
			if(L!=1) {
				for(int i=0;i<N;i+=L) {
					for(int j=0;j<N;j+=L) {
						rotate(i,j);
					}
				}
			}
			minus();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&arr[i][j]>0) {
					bfs(i,j);
				}
			}
		}
		answer=answer==1?0:answer;
		System.out.print(total+"\n"+answer);
	}
	static void rotate(int x,int y) {
		int[][]tmp = new int[L][L];
		for(int i=0;i<L;i++) {
			for(int j=0;j<L;j++) {
				tmp[j][L-i-1]=arr[i+x][j+y];
			}
		}
		for(int i=0;i<L;i++) {
			for(int j=0;j<L;j++) {
				arr[i+x][j+y] = tmp[i][j];
			}
		}
	}
	static void minus() {
		boolean[][]check=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int count=0;
				for(int d=0;d<4;d++) {
					int nx=i+dx[d];
					int ny=j+dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N||arr[nx][ny]<1)count++;
				}
				if(count>=2)check[i][j]=true;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j])arr[i][j]--;
			}
		}
	}
	static void bfs(int i,int j) {
		int count=1;
		Queue<int[]>q = new LinkedList<>();
		visited[i][j]=true;
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[]now=q.poll();
			total+=arr[now[0]][now[1]];
			for(int d=0;d<4;d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny])continue;
				visited[nx][ny]=true;
				if(arr[nx][ny]<1)continue;
				q.add(new int[] {nx,ny});
				count++;
			}
		}
		answer=Math.max(answer, count);
	}
}