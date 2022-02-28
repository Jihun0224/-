import java.util.Scanner;

public class Main_B11050 {
	static int fac(int n) {
		if(n<=1)return 1;
		return n*fac(n-1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		System.out.println(fac(n)/(fac(k)*fac(n-k)));
	}

}
