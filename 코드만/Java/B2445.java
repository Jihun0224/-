package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2445 {

	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int layer=Integer.parseInt(br.readLine())*2-1;
			for(int i=0;i<layer;i++) {
				if(i<=layer/2) {
					for(int j=0;j<i+1;j++) {
						System.out.printf("*");
					}
					for(int k=(layer-1)/2;k>i;k--) {
						System.out.printf("  ");
					}
					for(int j=0;j<i+1;j++) {
						System.out.printf("*");
					}
				}
				else {
					for(int j=i;j<layer;j++) {
						System.out.printf("*");
					}
					for(int k=layer/2;k<i;k++) {
						System.out.printf("  ");
					}
					for(int j=i;j<layer;j++) {
						System.out.printf("*");
					}
				}
				System.out.println();
			}
		}
	}
