package MT312;

import java.io.IOException;
import java.util.Scanner;

public class MT01 {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            solu(sc.nextInt());
        }
    }
    public static void solu(int tmp){
        boolean flag=(tmp%11==0);
        int count = 0;
        while(tmp>0){
            int a=tmp%10;
            tmp=tmp/10;
            count += a == 1?1:0;
        }

        if(flag||count>=2){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }

}
