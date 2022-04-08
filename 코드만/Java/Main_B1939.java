package _0408;

import java.io.*;
import java.util.*;

public class Main_B1939 {
	static class Node{
        int end, w;
        Node (int end, int w) {
            this.end = end;
            this.w = w;
        }
	}
	
	static int n,start,end,max;
	static ArrayList<Node>[]list;
	
	static int search() {
		int left=1,right=max,result=0;
		while(left<=right) {
			int mid=(left+right)/2;
			if(bfs(mid)) {
				result=mid;
				left=mid+1;
			}
			else right=mid-1;
		}
		return result;
	}
	static boolean bfs(int weight) {
		Queue<Integer>q=new LinkedList<>();
		boolean[]visited=new boolean[n];
		visited[start]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int cur=q.poll();
			if(cur==end)return true;
			for(Node node:list[cur]) {
				if(!visited[node.end]&&node.w>=weight) {
					visited[node.end]=true;
					q.add(node.end);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		list=new ArrayList[n];
		max=0;
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<Node>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,w));
			list[e].add(new Node(s,w));
			max=Math.max(max, w);
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken())-1;
		end=Integer.parseInt(st.nextToken())-1;
		System.out.println(search());
	}
}
