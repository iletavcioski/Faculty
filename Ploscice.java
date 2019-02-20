
//=============================================================================
// Dopolnite!
//=============================================================================

import java.util.*;

public class Ploscice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] v1 = new int[k];
		int[] v2 = new int[k];
		for (int i = 0; i < k; i++) {
			v1[i] = sc.nextInt();
			v2[i] = sc.nextInt();
		}
		
		for (int i = 0; i < k; i++) {
			for (int j = i + 1; j < k; j++) {
				if (v1[i] > v1[j] || (v1[i] == v1[j] && v2[i] > v2[j])) {
					int t1 = v1[j];
					int t2 = v2[j];
					v1[j] = v1[i];
					v2[j] = v2[i];
					v1[i] = t1;
					v2[i] = t2;
				}
			}
		}
		
		int count = 0;
		
		int x = 0;
		int y = 0;
		int poc = -1;
		for (int i = 0; i < k; i++) {
			if (v1[i] != poc) {
				poc = v1[i];
				if (y + v1[i] > n)
					break;
				y += v1[i];
				x = v2[i];
				if (x > n)
					continue;
				else
					count++;
			}
			else {
				x += v2[i];
				if (x > n)
					continue;
				else
					count++;
			}
			
		}
		System.out.println(count);
    }
}
