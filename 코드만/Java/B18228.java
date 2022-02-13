package Beakjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B18228 {

	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br.readLine();
			String[] ice = br.readLine().split(" ");
			int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE,temp;
			boolean flag=false;
			for(int i=0;i<ice.length;i++) {
				temp=Integer.parseInt(ice[i]);
				if(temp==-1)
					flag=true;
				else if(flag==false)
					min1=min1<temp?min1:temp;
				else
					min2=min2<temp?min2:temp;
			}
			System.out.println(min1+min2);
		}
	}