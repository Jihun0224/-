import java.util.Scanner;
public class Main_B11659 {
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[]arr= new int[N+1];
        for(int i=1;i<=N;i++)arr[i]+=arr[i-1]+sc.nextInt();
        for(int j=0;j<M;j++) {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	sb.append(arr[b]-arr[a-1]+"\n");
        }
        System.out.println(sb.toString());
	}
}
