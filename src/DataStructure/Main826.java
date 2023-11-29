package DataStructure;

import java.io.*;

public class Main826 {
    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int index, n, k, x, head;
    public static char op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        init();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            op = s[0].charAt(0);
            if (op == 'H') {
                x = Integer.parseInt(s[1]);
                addToHead(x);
            } else if (op == 'I') {
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                addToK(k - 1, x);
            } else if (op == 'D') {
                k = Integer.parseInt(s[1]);
                if (k == 0) {
                    head = ne[head];
                } else {
                    removeK(k - 1);
                }
            }
        }
        for (int i=head;i!=-1;i=ne[i]){
            bw.write(e[i]+" ");
        }
        br.close();
        bw.close();
    }
    //初始化
    private static void init() {
        index = 0;
        head = -1;
    }

    //链表头插入一个数
    private static void addToHead(int x) {
        e[index] = x;
        ne[index] = head;
        head = index++;
    }

    //K节点后插入一个数
    private static void addToK(int k, int x) {
        e[index] = x;
        ne[index] = ne[k];
        ne[k] = index++;
    }

    //删除k节点后的数
    private static void removeK(int k) {
        ne[k] = ne[ne[k]];
    }
}
