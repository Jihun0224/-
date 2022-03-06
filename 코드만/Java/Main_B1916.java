import java.io.*;
import java.util.*;
public class Main_B1916 {
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
		StringTokenizer st;
		int n,d,a,b,s,start,target;

		n=Integer.parseInt(br.readLine())+1;
		d=Integer.parseInt(br.readLine());
		PriorityQueue<Node>[] q = new PriorityQueue[n];
		for (int i = 1; i < n; i++) {
			q[i] = new PriorityQueue<>();
		}
		for (int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			q[a].add(new Node(b, s));
		}
		st = new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		target=Integer.parseInt(st.nextToken());
		
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] =0;
		while (!q[start].isEmpty()) {
			Node temp = q[start].poll();
			int end = temp.end;
			int weight = temp.weight;
			if (distance[end] != Integer.MAX_VALUE) continue;
			distance[end] = weight;
			if(end==target) {
				System.out.println(weight);
				System.exit(0);
			}
			for (Node node : q[end]) {
				q[start].add(new Node(node.end, node.weight+weight));
			}
		}			
	}
}