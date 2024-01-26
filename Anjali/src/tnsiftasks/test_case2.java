package tnsiftasks;
import java.util.Scanner;
public class test_case2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1 ; i<=n ;i++) {
			for(int j=1;j<=n;j++) {
				if( j==1 || i==1 && j!=1 && j!=n || i==n && j!=1 && j!=n || j==n ) {
					System.out.print("*");

				}else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}
		sc.close();

	}

}
