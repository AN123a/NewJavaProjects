package tnsiftasks;

import java.util.Scanner;

public class test_case3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=1 ; i<=n ;i++) {
			for(int j=1;j<=n;j++) {
				if(j==1 ) {
					System.out.print(i+" ");
				}else if(i==1) {
					System.out.print(j+" ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		    scan.close();

		}
        
	}

}
