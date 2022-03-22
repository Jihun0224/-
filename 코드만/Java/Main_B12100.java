import java.io.*;
import java.util.*;
public class Main_B12100 {
	static int n,answer=0;
	//5번 이동을 위한 dfs
	static void dfs(int depth,int[][]arr) {
		if(depth==5) {
			answer=Math.max(answer, getMax(arr));
			return;
		}
		for(int i=0;i<4;i++) {			
			dfs(depth+1,move(i,arr));
		}
	}
	//각 배열의 최댓값 찾는 메서드
	static int getMax(int[][]arr) {
		int temp=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]>temp)temp=arr[i][j];
			}
		}
		return temp;
	}
	//한 라인씩 이동
	static void lineMove(int[][]arr,Queue<Integer> q,int i,int d){
		int[]temp=new int[n];
		int num=0,index=0;
		while(!q.isEmpty()) {
			if(num==0)num=q.poll();
			if(!q.isEmpty()&&num==q.peek()) {
				q.poll();
				temp[index++]=num*2;
			}
			else temp[index++]=num;
			num=0;
		}
		if(d==0)for(int k=0;k<n;k++)arr[k][i]=temp[k];
		else if(d==1)for(int k=0;k<n;k++)arr[n-k-1][i]=temp[k];
		else if(d==2)for(int k=0;k<n;k++)arr[i][k]=temp[k];
		else for(int k=0;k<n;k++)arr[i][n-k-1]=temp[k];
	}
	//각 방향으로 배열 이동
	static int[][] move(int d,int[][]arr) {
		Queue<Integer> q = new LinkedList<>();
		int[][]map=new int[n][n];
		if(d==0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[j][i]!=0)q.offer(arr[j][i]);
				}
				lineMove(map,q,i,d);
			}
		}
		else if(d==1) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[n-j-1][i]!=0)q.offer(arr[n-j-1][i]);
				}
				lineMove(map,q,i,d);
			}
		}
		else if(d==2) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]!=0)q.offer(arr[i][j]);
				}
				lineMove(map,q,i,d);
			}
		}
		else {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][n-j-1]!=0)q.offer(arr[i][n-j-1]);
				}
				lineMove(map,q,i,d);
			}
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		
		int[][]arr=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, arr);
		System.out.println(answer);
	}

}
