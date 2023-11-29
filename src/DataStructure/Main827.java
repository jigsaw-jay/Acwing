package DataStructure;

import java.io.*;

public class Main827 {
    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] le = new int[N];
    public static int[] re = new int[N];
    public static int n, index, k, x;
    public static String op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        init();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            op = s[0];
            if (op.equals("L")) {
                x = Integer.parseInt(s[1]);
                insertToK(0,x);
            } else if (op.equals("R")) {
                x = Integer.parseInt(s[1]);
                insertToK(le[1],x );
            } else if (op.equals("D")) {
                k = Integer.parseInt(s[1]);
                deleteK(k+1);
            } else if (op.equals("IL")) {
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                insertToK(le[k+1],x);
            } else if (op.equals("IR")) {
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                insertToK(k+1,x);
            }
        }
        for (int i=re[0];i!=1;i=re[i]){
            bw.write(e[i]+" ");
        }
        br.close();
        bw.close();
    }
    //index初始值为2，故所有K都需要+1才是对应的第K个数
    public static void init() {
        index = 2;
        le[1] = 0;
        re[0] = 1;
    }

    //在第k个插入的数后插入x
    public static void insertToK(int k, int x) {
        e[index] = x;
        le[index] = k;
        re[index] = re[k];
        le[re[k]] = index;
        re[k] = index++;
    }

    //删除第K个插入的数
    public static void deleteK(int k) {
        re[le[k]] = re[k];
        le[re[k]] = le[k];
    }
}