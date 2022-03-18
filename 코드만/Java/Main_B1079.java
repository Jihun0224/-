import java.io.*;
import java.util.StringTokenizer;
//백준 1079. 마피아
public class Main_B1079 {
	
	static int n,g[],R[][],eunjin,answer;
	static boolean visited[];
	
	static void dfs(int depth,int live) {
		if(visited[eunjin]||live==1) {
			answer=Math.max(answer, depth);
			return;
		}
		if(live%2==0) {
			for(int i=0;i<n;i++) {
				if(i!=eunjin&&!visited[i]) {
					visited[i]=true;
					gUpdate(i,1);
					dfs(depth+1,live-1);
					gUpdate(i,-1);
					visited[i]=false;
				}
			}
		}
		else {
			int target=-1;;
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					if(target==-1)target=i;
					else target=g[i]>g[target]?i:target;
				}
			}
			visited[target]=true;
			dfs(depth,live-1);
			visited[target]=false;
		}
	}
	static void gUpdate(int i, int mode) {
		for (int j=0;j<n;j++) {
			if (!visited[j])g[j]+=R[i][j]*mode;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		g=new int[n];
		R=new int[n][n];
		visited= new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)g[i]=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				R[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		eunjin=Integer.parseInt(br.readLine());
		answer=0;
		dfs(0, n);
		System.out.println(answer);
	}
}