import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B1260 {
	
	static int n,m,v;
	static int map[][]=new int[1001][1001],check[]=new int[1001];
	static StringBuilder sb = new StringBuilder();
	static void dfs(int start){
		check[v]=1;
		sb.append(start + " ");
		for(int i=1;i<=n;i++){
			if(map[start][i]==1&&check[i]==0){
				check[i]=1;
				dfs(i);
			}
		}
	}
	static void bfs(int start){
		check[v]=2;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		while(!q.isEmpty()){
			v = q.poll();
			sb.append(v + " ");
			for(int i=1;i<=n;i++){
				if(map[v][i]==1&&check[i]!=2){
					check[i]=2;
					q.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		for(int i=1;i<=m;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y]=map[y][x]=1;
		}
		
		dfs(v);
		sb.append("\n");
		bfs(v);
		bw.write(sb.toString());
		bw.flush();
	}
}
