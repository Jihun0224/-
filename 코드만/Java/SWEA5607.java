package _0411;

import java.io.*;
import java.util.StringTokenizer;
//SWEA 5607. 조합
/* 
 * 1/r!(n-r)! 는 (r!(n-r)!)^-1이 동일함
 * 페르마의 소정리에 의해 (r!(n-r)!)^-1=(r!(n-r)!)^(p-2)
 * 이를 분할정복으로 답을 구함(r!(n-r)!)^(p-2) = 
 */
public class SWEA5607 {
	static int P=1234567891;
	static long pow(long num,int p) {
		if(p==1)return num%P;
		long temp=pow(num, p/2)%P;
		long temp2=(temp*temp)%P;
		if(p%2==1)return (temp2*num)%P;
		else return temp2;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			long[]fac=new long[N+1];
			fac[0]=1;
			for(int i=1;i<=N;i++)fac[i]=fac[i-1]*i%P;
			sb.append("#"+t+" "+(fac[N]*pow((fac[R]*fac[N-R]%P),P-2))%P+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
