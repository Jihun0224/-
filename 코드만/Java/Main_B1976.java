import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
//백준 1976 여행가자
public class Main_B1976 {
	
	static int[]p;
	static int find(int x) {
		if(p[x]==x)return x;
		return p[x]=find(p[x]);
	}
	static void union(int x,int y) {
		x=find(x);
		y=find(y);
		p[y]=x;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		p=new int[n+1];
		for(int i=1;i<=n;i++) p[i]=i;
		
				
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				if(i>=j) st.nextToken();
				else if(st.nextToken().equals("1")) union(i,j);
			}
		}
		st=new StringTokenizer(br.readLine());
		int[]route=new int[m];
		for(int i=0;i<m;i++)route[i]=Integer.parseInt(st.nextToken());
		
		int parent=find(route[0]);
		boolean flag=true;
		for(int i:route) {
			if(find(i)!=parent) {
				flag=false;
				break;
			}
		}
		if(flag)System.out.println("YES");
		else System.out.println("NO");
	}
}
