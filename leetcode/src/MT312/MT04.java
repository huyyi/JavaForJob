package MT312;


import java.util.Scanner;

public class MT04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        int flag = 1 << n - 1;
        int cur = flag - 1;
        int[] booms = new int[m];
        for (int i = 0; i < m; i++) {
            booms[i] = sc.nextInt();
        }
        int temp;
        for (int i = 0; i < m; i++) {
            temp = 1 << (booms[i] - 1);
            cur |= temp;
            if (cur == flag) {
                res++;
                cur = temp;
            }
        }
        System.out.println(res);

    }
}