package DataStructure;

import java.io.*;

/*835. Trie字符串统计*/
public class Main835 {
    public static int N = 20010;
    public static int[][] son = new int[26*N][26];
    public static int[] count = new int[N];
    public static int n, index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            char op = s[0].charAt(0);
            char[] str = s[1].toCharArray();
            if (op == 'I') {
                insert(str);
            } else if (op == 'Q') {
                bw.write(query(str) + "\n");
            }
        }
        br.close();
        bw.close();
    }

    private static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                return 0;
            } else {
                p = son[p][u];
            }
        }
        return count[p];
    }

    private static void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) son[p][u] = ++index;
            p = son[p][u];
        }
        count[p]++;
    }
}