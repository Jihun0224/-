import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;

public class SWEA1238 {
	
	static ArrayList<ArrayList<Integer>>arr;
	static int[] check;
	static void bfs(int start) {
		
		check[start]=1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty()) {
			int cur=q.poll();
			for (int i = 0; i < arr.get(cur).size(); i++) {
				int temp = arr.get(cur).get(i);
				if(check[temp]==0) {
					check[temp] = check[cur]+1;
					q.offer(temp);
				}
			}
		}
	}
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			check = new int[101];
			arr = new ArrayList<>();
			
	        for(int i=0; i<=100; i++){
	            arr.add(new ArrayList<Integer>());
	        }
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n/2;i++){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr.get(x).add(y);
				
			}
			bfs(start);
			int max = 0,answer=0;
			for (int i = 0; i <=100; i++) {
				if(max<=check[i]) {
					max =check[i];
					answer=i;
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
