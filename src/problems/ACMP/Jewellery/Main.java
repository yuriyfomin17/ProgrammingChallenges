package problems.ACMP.Jewellery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String info = br.readLine().trim();
        int number = Integer.parseInt(info);
        System.out.println(number + 1);
    }
}
