import java.util.Arrays;
import java.util.Scanner;

public class Lineup {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n;
		n = sc.nextInt();
		int arr2[] = new int[n];
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			 arr2[i] = k;
		}
		boolean cc = false;
		for (int i = 0; i < n; i++) {
			if (i == 0)
			{
				if(arr2[i+1] >= arr2[i]) {
					System.out.println(i);
					cc = true;
				}
			}
			else if(i == n - 1) {
				if(arr2[i-1] <= arr2[i]) {
					System.out.println(i);
					cc = true;
				}
			}
			else if (arr2[i-1] <= arr2[i] && arr2[i+1] >= arr2[i]) {
				System.out.println(i);
				cc = true;
			}
		}
		if (cc == false) {
			System.out.println("NOBEDEN");
		}
	}
}