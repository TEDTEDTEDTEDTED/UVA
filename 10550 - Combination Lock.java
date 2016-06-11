
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.*;

public class Main {



    public static int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int a = sc.nextInt() , b = sc.nextInt() , c = sc.nextInt() , d = sc.nextInt();
            if(a == 0 && b == 0 && c == 0) break;
            int ans = 1080;
            ans = ans + ((a < b) ?  (40 - b + a) * 9 :  (a - b ) * 9) + ((b > c) ? (40 - b + c) * 9 : (c - b) * 9 ) + ((c < d) ?  (40 - d + c) * 9 : (c - d) * 9 );
            out.println(ans);
        }
        out.flush();
        out.close();
    }
    static  class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }

}
