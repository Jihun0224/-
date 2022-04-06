package _0406;

import java.io.*;
import java.util.*;
//조합 + bfs
//조합으로 모든 경우를 다 탐색 -> 브루트 포스
public class Main_B17471 {
	static int n,answer=Integer.MAX_VALUE,population[];
	static boolean visited[],graph[][];
	static void comb(int depth,int r) {
		if(r==0) {
			ArrayList<Integer>a=new ArrayList<>();
			ArrayList<Integer>b=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(visited[i])a.add(i);
				else b.add(i);
			}
			int tempA=bfs(a,b);
			if(tempA!=-1) {
				int tempB=bfs(b, a);
				if(tempB!=-1) {
					answer=Math.min(answer,Math.abs(tempA-tempB));
				}
			}
			return;
		}
		for(int i=depth;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(depth+1, r-1);
				visited[i]=false;
			}
		}
	}
	static int bfs(ArrayList<Integer> a,ArrayList<Integer> b) {

		boolean[]check=new boolean[n];
		Queue<Integer>q=new LinkedList<Integer>();
		q.offer(a.get(0));
		check[a.get(0)]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int i=0;i<n;i++) {
				if(graph[cur][i]&&!check[i]&&!b.contains(i)) {
					check[i]=true;
					q.add(i);
				}
			}
		}
		int result=0;
		for(int i:a) {
			if(!check[i])return -1;
			result+=population[i];
		}
		return result;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		population=new int[n];
		graph=new boolean[n][n];
		visited=new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			population[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int size=Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				int temp = Integer.parseInt(st.nextToken())-1;
				graph[i][temp]=true;
			}
		}
		//n까지하면 중복 검색을 하게 되므로 n/2까지 탐색함
		for(int i=1;i<=n/2;i++) {
			comb(0, i);
		}
		if(answer==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(answer);
	}
}
