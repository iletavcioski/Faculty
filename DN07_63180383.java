import java.util.*;

public class DN07_63180383 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] v = new int[n + 1];
        int[] vl = new int[n + 1];
        int[] vr = new int[n + 1];
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            v[i] = sc.nextInt();
            sum += v[i];
        }
        vl[0] = 0;
        for (int i = 1; i < n; i++) {
            vl[i] = 0;
            vl[i] += vl[i - 1];
            vl[i] += v[i - 1];
        }
        vr[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            vr[i] = 0;
            vr[i] += vr[i + 1];
            vr[i] += v[i];
        }

        int q;
        q = sc.nextInt();
        long counter = 0;

        for (int i = 0; i < q; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            int l0 = 0;
            int r0 = sum;
            int mini = 1000000001;
            if (a < b) {
            	if (b - a >= sum) {
            		continue;
            	}
            }
            else if(b < a) {
            	if (a - b >= sum) {
            		continue;
            	}
            }
            while (l0 <= r0) {
                int mid0 = (l0 + r0) / 2;
                int l = 0;
                int r = n - 1;
                boolean c = false;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if ((b + vr[mid]) < (a + vl[mid])) {
                        r = mid - 1;
                    }
                    else {
                        if ((a + vl[mid] + mid0) < (b + vr[mid])) {
                            l = mid + 1;
                        }
                        else
                        {
                            c = true;
                            break;
                        }
                    }
                }
                if (c == false) {
                    l0 = mid0 + 1;
                }
                else {
                    r0 = mid0 - 1;
                    if (mid0 < mini) {
                        mini = mid0;
                    }
                }
            }
            l0 = 0;
            r0 = sum;
            while (l0 <= r0) {
                int mid0 = (l0 + r0) / 2;
                int l = 0;
                int r = n - 1;
                boolean c = false;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if ((a + vl[mid]) < (b + vr[mid])) {
                        l = mid + 1;
                    }
                    else {
                        if ((b + vr[mid] + mid0) < (a + vl[mid])) {
                            r = mid - 1;
                        }
                        else
                        {
                            c = true;
                            break;
                        }
                    }
                }
                if (c == false) {
                    l0 = mid0 + 1;
                }
                else {
                    r0 = mid0 - 1;
                    if (mid0 < mini) {
                        mini = mid0;
                    }
                }
            }
            counter += (long)mini;
        }
        System.out.println(counter);
    }
}