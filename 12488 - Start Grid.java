
import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        while(sc.ready())
        {
            int N = sc.nextInt();
            ArrayList<Integer> first = new ArrayList<>(N);
            ArrayList<Integer> second= new ArrayList<>(N);
            for(int i = 0 ; i < N ; ++i) first.add(sc.nextInt());
            for(int i = 0 ; i < N ; ++i) second.add(sc.nextInt());
            int sum = 0;
            for(int j = 0 ; j < first.size() ; ++ j)
            {
                int pos = 0;
                for(int i = 0 ; i < second.size() ; ++i)
                    if (second.get(i) == first.get(j)) pos = i;

                sum += (pos);
                second.remove(pos);
            }
            out.printf("%d\n" , sum);
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
