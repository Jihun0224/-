package _0411;
import java.util.*;
public class Main_B11401 {
	static int P=10007;
	static long pow(long num,int p) {
		if(p==1)return num%P;
		long temp=pow(num, p/2)%P;
		long temp2=(temp*temp)%P;
		if(p%2==1)return (temp2*num)%P;
		else return temp2;
	}
	public static void main(String[]s){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(),K=sc.nextInt();
		long[]fac=new long[N+1];fac[0]=1;
		for(int i=1;i<=N;i++)fac[i]=fac[i-1]*i%P;
		System.out.println((fac[N]*pow((fac[K]*fac[N-K]%P),P-2))%P);
	}
}
