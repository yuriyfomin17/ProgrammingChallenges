package problems.ACMP.SequenceSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String info = br.readLine();
        int initialLimit = Integer.parseInt(info);
        int N = Math.abs(Integer.parseInt(info));
        long result = (long) N * (1 + N) / 2;

        if (initialLimit < 0) System.out.println(-result + 1);
        else if (initialLimit == 0) System.out.println(1);
        else System.out.println(result);

    }
}
