import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B10282 {
	static class Node implements Comparable<Node>{
		public int end,weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n,d,c,a,b,s,total,answer;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken())+1;
			d=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			PriorityQueue<Node>[] q = new PriorityQueue[n];
			for (int i = 1; i < n; i++) {
				q[i] = new PriorityQueue<>();
			}
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				s=Integer.parseInt(st.nextToken());
				q[b].add(new Node(a, s));
			}
			int[] distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[c] =0;
			answer=0;
			total=n-1;
			while (!q[c].isEmpty()) {
				Node temp = q[c].poll();
				int end = temp.end;
				int weight = temp.weight;
				if (distance[end] != Integer.MAX_VALUE) continue;
				distance[end] = weight;
				for (Node node : q[end]) {
					q[c].add(new Node(node.end, node.weight+weight));
				}
			}
			
			for(int j=1;j<n;j++) {
				if(distance[j]==Integer.MAX_VALUE)total--;
				else answer=Math.max(answer, distance[j]);
			}
			sb.append(total+" "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
