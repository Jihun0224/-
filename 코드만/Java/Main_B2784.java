import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2784 {
	static String[]arr = new String[6];
	static boolean[]visited1=new boolean[6];
	static boolean[]visited2=new boolean[3];
	static int[] result= new int[3];
	static int[] result2= new int[3];
	static int[] temp = new int[3];
	
	static void check(int depth,char[][]c1) {
		
		if(depth==3){
			char[][]c2 = new char[3][3];
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					c2[j][i]=arr[result2[i]].charAt(j);
				}
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(c1[i][j]!=c2[i][j])
						return;					
				}
			}
			for(char[]a:c1) {
				for(int i=0;i<3;i++) {
					System.out.print(a[i]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		for(int i=0;i<3;i++) {
			if(!visited2[i]) {
				visited2[i]=true;
				result2[depth]=temp[i];
				check(depth+1,c1);
				visited2[i]=false;
			}
		}
	}
	
	static void search(int depth) {
		
		if(depth==3) {
			char[][]c1 = new char[3][3];
			int index1=0,index2=0;
			
			for(int i=0;i<6;i++) {
				if(visited1[i]) c1[index1]=arr[result[index1++]].toCharArray();
				else temp[index2++]=i;
			}
			check(0,c1);
			return;
		}
		for(int i=0;i<6;i++) {
			if(!visited1[i]) {
				visited1[i]=true;
				result[depth]=i;
				search(depth+1);
				visited1[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<6;i++) {
			arr[i]=br.readLine();
		}
		search(0);
		System.out.println(0);
	}
}
