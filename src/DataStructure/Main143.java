package DataStructure;

import java.io.*;

/*143. 最大异或对*/
public class Main143 {
    public static int N = 100010;
    public static int M = 31 * N;
    public static int[][] son = new int[M][2];
    public static int[] a = new int[N];
    public static int index, n, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < n; i++) {
            insert(a[i]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, query(a[i]));
        }
        bw.write(res + " ");
        br.close();
        bw.close();
    }

    private static int query(int x) {
        int p = 0, temp = 0;
        for (int i = 31; i >= 0; i--) {
            //x的二进制序列，从高位到地位
            int u = (x >> i) & 1;
            if (son[p][u ^ 1] == 0) {
                p = son[p][u];
            } else {
                temp += 1 << i;
                p = son[p][u ^ 1];
            }
        }
        return temp;
    }

    private static void insert(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (son[p][u] == 0) son[p][u] = ++index;
            p = son[p][u];
        }
    }
}