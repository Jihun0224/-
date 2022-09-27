import java.io.*;
import java.util.*;
public class Main_BOJ1516 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[]indegree=new int[N+1];
		int[]dp=new int[N+1];
		int[]time=new int[N+1];
		
		List<List<Integer>>graph = new ArrayList<>();
		
		for(int i=0;i<=N;i++)graph.add(new ArrayList<>());
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i+1]=Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1)break;
				graph.get(num).add(i+1);
				indegree[i+1]++;
			}
		}
		
		Queue<Integer>q=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
				dp[i]=time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int i:graph.get(now)) {
				indegree[i]--;
				dp[i]=Math.max(dp[now]+time[i],dp[i]);
				if(indegree[i]==0)q.add(i);
			}
		}
		
		for(int i=1;i<=N;i++)System.out.println(dp[i]);
	}

}