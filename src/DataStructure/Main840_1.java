package DataStructure;

import java.io.*;
/*840. 模拟散列表-拉链法*/
public class Main840_1 {
    public static int N = 100010;
    public static int[] h = new int[N]; //存放地址，初始值为-1，表面该地址尚无元素
    public static int[] e = new int[N]; //存放数值
    public static int[] ne = new int[N]; //存放链中的下一个地址
    public static int n, x, index;
    public static char op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        init();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            op = s[0].charAt(0);
            x = Integer.parseInt(s[1]);
            if (op == 'I') {
                insert(x);
            } else if (op == 'Q') {
                bw.write(query(x) + "\n");
            }
        }
        br.close();
        bw.close();
    }

    private static void init() {
        for (int i = 0; i < h.length; i++) {
            h[i]=-1;
        }
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[index] = x;
        ne[index] = h[k];
        h[k] = index++;
    }

    private static String query(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return "Yes";
            }
        }
        return "No";
    }

}