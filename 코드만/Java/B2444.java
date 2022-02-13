package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2444 {

	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int layer=Integer.parseInt(br.readLine());
			for(int i=0; i<layer*2-1;i++) {
				for(int j=0;j<layer*2-1;j++) {
					if(j<layer/2) {
						System.out.printf(" ");
					}
					else {
						System.out.printf("*");
					}
				}
				System.out.println();
			}
		}
	}
