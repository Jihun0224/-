import java.io.*;
import java.util.*;
public class Main_BOJ14499_주사위굴리기 {
	static int N,M,x,y,K,map[][],dice[],top;
	static int[]dx= {0,0,0,-1,1};
	static int[]dy= {0,1,-1,0,0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dice=new int[6];
		map=new int[N][M];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int d=Integer.parseInt(st.nextToken());
			move(d);
		}
		System.out.print(sb.toString());
	}
	static void move(int d) {
		int nx = x+dx[d];
		int ny = y+dy[d];
		if(nx<0||ny<0||nx>=N||ny>=M)return;
		x=nx;
		y=ny;
		int tmp=dice[0];
		switch (d) {
		case 1:
			dice[0]=dice[3];
			dice[3]=dice[1];
			dice[1]=dice[2];
			dice[2]=tmp;
			break;
		case 2:
			dice[0]=dice[2];
			dice[2]=dice[1];
			dice[1]=dice[3];
			dice[3]=tmp;
			break;
		case 4:
			dice[0]=dice[5];
			dice[5]=dice[1];
			dice[1]=dice[4];
			dice[4]=tmp;
			break;
		default:
			dice[0]=dice[4];
			dice[4]=dice[1];
			dice[1]=dice[5];
			dice[5]=tmp;
			break;
		}
		if(map[nx][ny]!=0) {
			dice[1]=map[nx][ny];
			map[nx][ny]=0;
		}else {
			map[nx][ny]=dice[1];
		}
		sb.append(dice[0]+"\n");
	}
}
