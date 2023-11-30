package DataStructure;

import java.io.*;

/*模拟队列*/
public class Main829 {
    public static int N = 100010;
    public static int[] que = new int[N];
    public static int tt, hh, n, x;
    public static String op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        init();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            op = s[0];
            if (op.equals("push")) {
                x=Integer.parseInt(s[1]);
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
        bw.close();
    }

    public static void init() {
        tt = -1;
        hh = 0;
    }

    public static void push(int x) {
        que[++tt] = x;
    }

    public static void pop() {
        hh++;
    }

    public static void empty() {
        if (hh <= tt) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void query() {
        System.out.println(que[hh]);
    }
}