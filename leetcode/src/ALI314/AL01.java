package ALI314;

import java.util.*;

public class AL01 {
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().substring(2);
        int res = 0;
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 1);
        map.put('3', 2);
        map.put('4', 1);
        map.put('5', 2);
        map.put('6', 2);
        map.put('7', 3);
        map.put('8', 1);
        map.put('9', 2);
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 4);
        char[] str = s.toCharArray();
        for (char c : str) {
            res += map.get(c);
        }
        System.out.println(res);
    }
}
