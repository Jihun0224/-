import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1647 {
	static int[]p;
	static class Edge implements Comparable<Edge>{
		public int start,end,weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	static int find(int x) {
		if(x==p[x])return x;
		return p[x]=find(p[x]);
	}
	static boolean union(int x,int y) {
		int a=find(x);
		int b=find(y);
		
		if(a==b)return false;
		p[b]=a;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		p=new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i]=i;
		}
		Edge[]edgeList = new Edge[m];
		int x,y,w;
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			edgeList[m]=new Edge(x,y,w);
		}
		Arrays.sort(edgeList);
		int result=0,cnt=0;
		for(Edge edge:edgeList) {
			if(union(edge.start, edge.end)) {
				result+=edge.weight;
				if(++cnt==n-2)break;
			}
		}
		System.out.println(result);
	}
}