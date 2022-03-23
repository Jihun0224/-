import java.io.*;
import java.util.*;
//백준 16946. 벽 부수고 이동하기 4
public class Main_B16946 {
	
	static int n,m,arr[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static boolean[][]visited;
	static int groupNum=0;
	static ArrayList<Integer>groupCnt = new ArrayList<>();
	static void bfs(int x,int y) {
		Queue<int[]>q=new LinkedList<>();
		visited[x][y]=true;
		arr[x][y]=groupNum;
		q.offer(new int[] {x,y});
		int cnt=1;
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			for(int i=0;i<4;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					if(arr[nx][ny]==0) {
						cnt++;
						q.offer(new int[] {nx,ny});
						arr[nx][ny]=groupNum;
					}
				}
			}
		}
		groupNum++;
		groupCnt.add(cnt);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		visited=new boolean[n][m];
		int [][]answer=new int[n][m];
		HashSet<Integer>set = new HashSet<>();
		for(int i=0;i<n;i++) {
			char[]temp=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				arr[i][j]=(int)temp[j]-48;
				if(arr[i][j]==1)arr[i][j]=-1;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==-1) {
					answer[i][j]=1;
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0&&ny>=0&&nx<n&&ny<m&&arr[nx][ny]!=-1) {
							set.add(arr[nx][ny]);
						}
					}
				}
				for(int k:set)answer[i][j]+=groupCnt.get(k);
				set.clear();
				sb.append(answer[i][j]%10);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}