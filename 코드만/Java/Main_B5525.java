import java.io.*;

public class Main_B5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		br.readLine();
		char[]T=br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder("I");
		for(int i=0;i<n;i++) sb.append("OI");
		char[]P=sb.toString().toCharArray();
		int p=P.length,t=T.length;
		int[]pi=new int[p];
		for(int i=1,j=0;i<p;i++){
			while(j>0&&P[i]!=P[j])j=pi[j-1];
			if(P[i]==P[j])pi[i]=++j;
		}
		int cnt=0;
		for(int i=0, j=0; i<t; i++) {
			while(j>0 && T[i]!=P[j]) j = pi[j-1];
			if(T[i]==P[j]&&++j==p){
				cnt++;
				j=pi[j-1];
			}
		}
		System.out.println(cnt);
	}
}