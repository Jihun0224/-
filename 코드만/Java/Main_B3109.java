import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 빵집
public class Main_B3109 {
	
	static int R,C;
	static char[][]arr;
	//y값 이동 순위: 오른쪽 위 대각, 오른쪽, 오른쪽 아래 대각
	static int[]dy= {-1,0,1};
	static int answer=0;
	//방문 여부 체크 -> 시간초과 해결
	static boolean[][] visited;
	static boolean dfs(int depth,int y) {
		if(depth==C) return true;
		
		else {
			for(int i=0;i<3;i++) {
				int ny=y+dy[i];
				if(ny>=0&&ny<R&&arr[ny][depth]!='x'&&!visited[ny][depth]) {
					visited[ny][depth]=true;
					if(dfs(depth+1,ny)) {
						arr[ny][depth]='x';
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		for(int i=0;i<R;i++) {
			if(dfs(0,i))answer++;
		}
		System.out.println(answer);
	}
}
