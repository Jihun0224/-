import java.io.*;
import java.util.*;
public class Main_BOJ21610_마법사상어와비바라기 {
	static int N,M,A[][];
	static boolean cloud[][];
	static int[]dx= {0,-1,-1,-1,0,1,1,1};
	static int[]dy= {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		A=new int[N][N];
		cloud=new boolean[N][N];
		cloud[N-1][0]=cloud[N-1][1]=cloud[N-2][0]=cloud[N-2][1]=true;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken())-1;
			int s=Integer.parseInt(st.nextToken());
			move(d,s);
		}
		System.out.print(getAnswer());
	}
	static int getAnswer() {
		int a=0;
		for(int[]r:A) {
			for(int i:r) {
				a+=i;
			}
		}
		return a;
	}
	static void move(int d,int s) {
		boolean[][]tmp=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j]) {
					s%=N;
					int nx=((i+N)+(dx[d]*s))%N;
					int ny=((j+N)+(dy[d]*s))%N;
					tmp[nx][ny]=true;
					A[nx][ny]++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(tmp[i][j]) {
					int count=0;
					for(int k=1;k<8;k+=2) {
						int cx=i+dx[k];
						int cy=j+dy[k];
						if(cx<0||cy<0||cx>=N||cy>=N||A[cx][cy]==0)continue;
						count++;
					}
					A[i][j]+=count;
				}
			}
		}
		createCloud(tmp);
	}
	static void createCloud(boolean[][]now) {
		boolean[][]newCloud=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(now[i][j]||A[i][j]<2)continue;
				newCloud[i][j]=true;
				A[i][j]-=2;
			}
		}
		cloud=newCloud;
	}
}