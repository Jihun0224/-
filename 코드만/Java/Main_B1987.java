import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 1987 알파벳 -> dfs
public class Main_B1987 {

	static int[][]arr;
	static int c,r,answer=Integer.MIN_VALUE;
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,1,-1};
	static void dfs(int x,int y,int count,boolean[] visited){
		int nx,ny;
		for(int i=0;i<4;i++) {
			nx=x+dx[i];
			ny=y+dy[i];
			//범위 체크
			if(nx>=0&&nx<r&&ny>=0&&ny<c) {
				//현재 지나간 상태인지 체크
				if(!visited[arr[nx][ny]]) {
					visited[arr[nx][ny]]=true;
					dfs(nx,ny,count+1,visited);
					visited[arr[nx][ny]]=false;
				}
			}
		}
		answer=Math.max(answer, count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visited = new boolean[27];
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for(int i=0;i<r;i++) {
			String temp=br.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j]=((int)temp.charAt(j)-64);
			}
		}

		visited[arr[0][0]]=true;
		dfs(0,0,1,visited);
		System.out.println(answer);
	}

}
