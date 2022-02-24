import java.io.*;

public class Main_B1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int t = T.length, p = P.length;
		int[]pi = new int[p];
		
		for(int i=1, j=0; i<p; i++) {
			while(j>0 && P[i]!=P[j]) j=pi[j-1];
			if(P[i]==P[j])pi[i]=++j;
		}
		int cnt=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0, j=0; i<t; i++) {
			while(j>0 && T[i]!=P[j]) j = pi[j-1];
			if(T[i]==P[j]&&++j==p) {
				cnt++;
				sb.append(i-p+2+" ");
				j = pi[j-1];
			}
		}
		bw.append(Integer.toString(cnt)+"\n");
		if(cnt>0) 
				bw.append(sb.toString());
		bw.flush();
	}
}