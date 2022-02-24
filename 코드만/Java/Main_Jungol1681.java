import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정올 1681 해밀턴 순환회로 -> 순환회로
public class Main_Jungol1681 {

	static int n,answer=Integer.MAX_VALUE;
	static int[][]map;
	static boolean[]visited;
	//dfs
	static void dfs(int depth,int sum,int start) {
		//가지치기
		if(sum>answer)return;
		//다 탐색했고 회사로 돌아오는 길 있으면
		if(depth==n&&map[start][0]!=0) {
			sum+=map[start][0];
			answer=answer>sum?sum:answer;
			return;
		}
		//0은 시작점이므로 1부터 탐색
		for(int i=1;i<n;i++) {
			if(visited[i]||map[start][i]==0)continue;
			visited[i]=true;
			dfs(depth+1,sum+map[start][i],i);
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//시작 지점이 0으로 고정이므로 depth 1시작
		dfs(1,0,0);
		System.out.println(answer);
	}
}
