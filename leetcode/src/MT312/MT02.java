package MT312;

import java.util.Scanner;

public class MT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] prefix = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if (i == 0) {
                prefix[i] = num[i];
            } else {
                prefix[i] = num[i] * prefix[i - 1];
            }
            if (prefix[i] > 0) {
                res++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (prefix[i] * prefix[j] > 0) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }
}
