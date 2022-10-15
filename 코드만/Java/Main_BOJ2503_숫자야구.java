import java.io.*;
import java.util.*;

public class Main_BOJ2503_숫자야구 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine()),ans=0;
		boolean[] check=new boolean[1000];
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] num=st.nextToken().toCharArray();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			for(int i=123;i<988;i++) {
				if(check[i])continue;
				char now[] = String.valueOf(i).toCharArray();
				if((now[0]=='0'||now[1]=='0'||now[2]=='0')||(now[0]==now[1]||now[1]==now[2]||now[0]==now[2])) {
					check[i]=true;
					continue;
				}
				int s=0,b=0;
				for(int j=0;j<3;j++) {
					for(int k=0;k<3;k++) {
						if(num[j]==now[k]) {
							if(j==k)s++;
							else b++;
						}
					}
				}
				if(s!=strike||b!=ball)check[i]=true;
			}
		}
		for(int i=123;i<988;i++)if(!check[i])ans++;
		System.out.print(ans);
	}
}