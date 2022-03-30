import java.io.*;
import java.util.*;

public class Main_B16918 {
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static int R,C,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		char[][] arr=new char[R][C];
		for(int i=0;i<R;i++) 
			arr[i]=br.readLine().toCharArray();			
		char[][]answer;
		if(N<=1)answer=arr;
		else if(N%2==0) answer=fullO();
		else if(N%4==3)answer=bomb(arr);
		else answer=bomb(bomb(arr));
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static char[][]fullO(){
		char[][]temp=new char[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				temp[i][j]='O';
			}
		}
		return temp;
	}
	static char[][] bomb(char[][]arr) {
		char[][]temp=fullO();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]=='O') {
					temp[i][j]='.';
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx<0||ny<0||nx>=R||ny>=C)continue;
						temp[nx][ny]='.';
					}
				}
			}
		}
		return temp;
	}
}