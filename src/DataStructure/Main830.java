package DataStructure;

import java.io.*;

/*单调栈*/
public class Main830 {
    public static int N = 100010;
    public static int[] stk = new int[N];
    public static int tt = -1, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i : mStack(n, s)) {
            bw.write(i + " ");
        }
        br.close();
        bw.close();
    }

    public static int[] mStack(int n, String[] s) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s[i]);
            //当栈不为空，且栈顶元素>=X，则弹出栈顶元素
            while (tt != -1 && stk[tt] >= x) {
                tt--;
            }
            if (tt != -1) {
                res[i] = stk[tt];
            } else {
                res[i] = -1;
            }
            stk[++tt] = x;
        }
        return res;
    }
}