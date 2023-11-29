package DataStructure;

import java.io.*;

public class Main828 {
    public static int N = 100010;
    public static int[] stk = new int[N];
    public static int tt, n, x;
    public static String op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            op = s[0];
            if (op.equals("push")) {
                x = Integer.parseInt(s[1]);
                push(x);
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("empty")) {
                empty();
            } else if (op.equals("query")) {
                query();
            }
        }
        br.close();
    }

    public static void push(int x) {
        stk[++tt] = x;
    }

    public static void pop() {
        tt--;
    }

    public static void empty() {
        if (tt == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void query() {
        System.out.println(stk[tt]);
    }
}