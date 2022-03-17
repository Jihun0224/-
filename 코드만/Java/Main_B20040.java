import java.io.*;
import java.util.StringTokenizer;

//백준 20040. 사이클 게임
public class Main_B20040 {
	static int[]arr;
	static int find(int x) {
		if(arr[x]==x)return x;
		return arr[x]=find(arr[x]);
	}
	static boolean union(int x,int y) {
		int a=find(x);
		int b=find(y);
		if(a==b)return true;
		if(a<b)arr[b]=a;
		else arr[a]=b;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int turn = Integer.parseInt(st.nextToken());
		int i,a,b;
		arr=new int[n];
		boolean flag=false;
		for(i=0;i<n;i++)arr[i]=i;
		for(i=0;i<turn;i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(union(a,b)) {
				flag=true;
				break;
			}
		}
		if(flag)System.out.println(i+1);
		else System.out.println(0);
	}
}
