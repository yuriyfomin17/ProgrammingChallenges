package problems.ACMP.Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String info = br.readLine();
        long[] arr = Arrays.stream(info.split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(arr[0] + arr[1]);
    }
}
