package tnsiftasks;

public class test_case5 {
	
	public static void main(String[] args) {
		int n = 5; // Change the value of 'n' to control the number of rows

		for (int i = 0; i < n; i++) {
			// Print spaces
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}

			// Print characters
			for (int k = 0; k < n - i; k++) {
				char ch = (char) ('A' + k);
				System.out.print(ch + " ");
			}

			System.out.println();
		}
	}

}
