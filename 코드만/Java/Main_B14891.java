package _0413;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B14891 {
	static int top[],wheel[][],posR[];
	static boolean visited[];
	static void rotate() {
		for(int i=1;i<5;i++) {
			if(posR[i]!=0) {
				if(posR[i]==1) top[i]=(top[i]+7)%8;
				else top[i]=(top[i]+1)%8;
				posR[i]=0;
			}
			visited[i]=false;
		}
	}
	static void isRotate(int num,int d) {
		if(num<1||num>4)return;
		visited[num]=true;
		posR[num]=d;
		if(num-1>0&&!visited[num-1]) {
			if(wheel[num][(top[num]+6)%8]!=wheel[num-1][(top[num-1]+2)%8]) {
				isRotate(num-1,d*-1);
			}
		}
		if(num+1<5&&!visited[num+1]) {
			if(wheel[num][(top[num]+2)%8]!=wheel[num+1][(top[num+1]+6)%8]) {
				isRotate(num+1,d*-1);
			}
		}
	}
	static int getAnswer() {
		int result=0,point=1;
		for(int i=1;i<5;i++) {
			result+=wheel[i][top[i]]*point;
			point*=2;
		}
		return result;
	}
	public static void main(String[]s) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		top=new int[5];
		wheel=new int[5][8];
		posR=new int[5];
		visited=new boolean[5];
		for(int i=1;i<5;i++) {
			char[]temp=br.readLine().toCharArray();
			for(int j=0;j<8;j++) {
				wheel[i][j]=temp[j]-'0';
			}
		}
		int k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			isRotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			rotate();
		}
		System.out.println(getAnswer());
	}
}
