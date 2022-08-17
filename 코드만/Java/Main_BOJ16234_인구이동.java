import java.io.*;
import java.util.*;

public class Main_BOJ16234_인구이동 {

	static int N,L,R,groupNum,arr[][],group[][];
	static int dx[]= {1,-1,0,0} ,dy[]= {0,0,1,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		groupNum=0;
		group=new int[N][N];
		int answer=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(group[i][j]==0) {
						groupNum+=1;
						bfs(i,j);
					}
				}
			}
			if(groupNum==N*N)break;
			answer+=1;
			groupNum=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					group[i][j]=0;
				}
			}
		}
		System.out.print(answer);
	}
	static void bfs(int i,int j) {
		Queue<int[]>q=new LinkedList<>();
		Queue<int[]>save = new LinkedList<>();
		q.add(new int[] {i,j});
		save.add(new int[] {i,j});
		group[i][j]=groupNum;
		int count=1;
		int total=arr[i][j];
		while(!q.isEmpty()) {
			int[]now=q.poll();
			int x=now[0];
			int y=now[1];
			for(int d=0;d<4;d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N||group[nx][ny]!=0)continue;
				int diff=Math.abs(arr[x][y]-arr[nx][ny]);
				if(L>diff||diff>R)continue;
				group[nx][ny]=groupNum;
				int[]next={nx,ny};
				q.add(next);
				save.add(next);
				count+=1;
				total+=arr[nx][ny];
			}
		}
		while(!save.isEmpty()) {
			int[] now=save.poll();
			arr[now[0]][now[1]]=total/count;
		}
	}
}