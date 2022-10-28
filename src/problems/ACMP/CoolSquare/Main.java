package problems.ACMP.CoolSquare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String info = br.readLine().trim();
        if (info.equals("5")) System.out.println("25");
        else {
            int number = getNumberBeforeFive(info);

            System.out.println((long) number * (number+1) + "25" );
        }

    }

    public static int getNumberBeforeFive(String str){
        return Integer.parseInt(str.substring(0, str.lastIndexOf("5")));

    }
}
