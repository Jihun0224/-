package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2564 {
	static int N,M,K;
	static int[]pos;
	static int[][]cmd;
	//방향을 기반으로 좌표 값으로 변환
	static int[] setLocaiotn(int x,int y){
		int[] result = new int[2];
		//남 or 북 
		if(x==1 || x==2) {
			if(x==1)x=N;
			else x=0;
		}
		//서 or 동
		else {
			int temp=x;
			x=N-y;
			if(temp==3) y=0;
			else y=M;	
			
		}
		result[0]=x;
		result[1]=y;
		return result;
	}
	static void cal() {
		int sum=0;
		for(int i=0;i<K;i++) {
			//북 남으로 마주봄
			if(Math.abs(pos[0]-cmd[i][0])==N) 
				sum+=Math.min(pos[1]+cmd[i][1],2*M-(pos[1]+cmd[i][1])) +N;
			//동 서로 마주봄
			else if(Math.abs(pos[1]-cmd[i][1])==M) 
				sum+=Math.min(pos[0]+cmd[i][0],2*N-(pos[0]+cmd[i][0]))+M;
			//그 외
			else 
				sum+=Math.abs(cmd[i][0]-pos[0])+Math.abs(cmd[i][1]-pos[1]);
		}
		System.out.println(sum);
	}
	public static void main(String[] args) throws IOException {
		input();
		cal();
	}
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		cmd=new int[K][2];
		int x,y;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			cmd[i]=setLocaiotn(x, y);
		}
		st = new StringTokenizer(br.readLine());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		pos=setLocaiotn(x, y);
	}
}
