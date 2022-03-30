import java.io.*;
import java.util.*;
//SWEA 3124 최소 스패닝 트리
public class SWEA_3124 {
	static class Edge implements Comparable<Edge>{
		int start,end,weight;

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
	
	static int n,m;
	static int[] parents;
	static Edge[]edgeList;
	
	public static int find(int x) {
		if (x==parents[x]) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	public static boolean union(int x,int y) {
		int a=find(x);
		int b=find(y);
		
		if(a==b)return false;
		parents[b]=a;
		return true;
	}

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	int T= Integer.parseInt(br.readLine());
        	for(int t=1;t<=T;t++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				parents = new int[n+1];
				for (int i=1;i<=n;i++) {
					parents[i] = i;
				}
				edgeList = new Edge[m];
				for(int i=0;i<m;i++) {
					st = new StringTokenizer(br.readLine());
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					edgeList[i] = new Edge(from,to,weight);
				}			
				Arrays.sort(edgeList);
				long result=0;
				int cnt=0;
				for(Edge edge:edgeList) {
					if(union(edge.start, edge.end)) {
						result+=edge.weight;
						if(++cnt==n-1)break;
					}
				}
				System.out.println("#"+t+" "+result);
          }
	}
}