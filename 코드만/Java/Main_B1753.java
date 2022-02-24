import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_B1753 {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken())+1;
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		//노드 정보를 저장할 q
		PriorityQueue<Node>[] q = new PriorityQueue[v];
		for (int i = 1; i < v; i++) {
			q[i] = new PriorityQueue<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			q[x].add(new Node(y, w));
		}
		
		int[] distance = new int[v];		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] =0;
		
		//모든 간선을 다 이용할 때까지
		while (!q[start].isEmpty()) {
			Node temp = q[start].poll();
			int end = temp.end;
			int weight = temp.weight;
			//방문 여부 체크
			if (distance[end] != Integer.MAX_VALUE) continue;
			//도착지까지의 최단 거리 저장
			distance[end] = weight;
			//end와 연결돼 있던 노드 start에 추가 -> start -> end -> end와 연결된 노드
			for (Node node : q[end]) {
				q[start].add(new Node(node.end, node.weight+weight));
			}
		}
		
		for(int j=1;j<v;j++) {
			if(distance[j]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[j]);
		}
	}
}
