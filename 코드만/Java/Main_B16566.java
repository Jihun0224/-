import java.io.*;
import java.util.*;
public class Main_B16566 {
	static int n,p[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int[]arr=new int[m];
		p=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<=n;i++)p[i]=i;
		int minsu;
		st=new StringTokenizer(br.readLine());
		while(k-->0) {
			minsu=Integer.parseInt(st.nextToken());
	        int start = 0, end = m-1, mid;
	        while(start < end){
	            mid=(start+end)/2;
	            if(minsu>=find(arr[mid]))start=mid+1;
	            else end=mid;
	        }
			System.out.println(find(arr[end]));
			if(end==0) union(0,arr[end]);
			else union(arr[end-1],arr[end]);
		}
	}
static int find(int x) {
	if(x==p[x])return x;
	return p[x]=find(p[x]);
}
static void union(int x,int y) {
	int a=find(x);
	int b=find(y);
	if(a!=b)p[b]=a;
	}
}