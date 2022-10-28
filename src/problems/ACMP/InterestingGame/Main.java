package problems.ACMP.InterestingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int firstNumber = Integer.parseInt(br.readLine().trim());
        int secondNumber = 9 - firstNumber;
        System.out.printf("%d%d%d", firstNumber, 9, secondNumber);
    }
}
