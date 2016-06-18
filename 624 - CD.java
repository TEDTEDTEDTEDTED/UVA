
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; sc.ready(); t ++)
        {
            int ALL = sc.nextInt() , N = sc.nextInt();
            int arr [] = new int[N];
            for(int i =0 ; i < N ; ++i) arr[i] = sc.nextInt();

            ArrayList<Integer> res = new ArrayList<Integer>();
            int bestSum = Integer.MAX_VALUE;

            int mask = (1 << N);
            while (mask -- > 0)
            {
                int sum = 0;
                for(int i = 0 ; i < N ; ++i)
                    if(((1 << i) & mask) !=0) sum += arr[i];
                if (sum <= ALL && Math.abs(ALL - sum) < Math.abs(ALL - bestSum))
                {
                    res = new ArrayList<>();
                    for(int i = 0 ; i < N ; ++i)
                        if(((1 << i) & mask) !=0) res.add(arr[i]);
                    bestSum = sum;
                }
            }

            for(int i = 0 ; i < res.size() ; ++i) out.printf("%d " , res.get(i));
            out.printf("sum:%d\n" , bestSum);
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
