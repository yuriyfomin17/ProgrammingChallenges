package problems.CSNET.NumberOfSubstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codechef {
    static String stringToBeProcessed;
    static String stringToBeFind;
    static int currentLengthOfString;

    public static void findNumberOfStrings() {
        String[] arr = stringToBeProcessed.split(stringToBeFind);
        long N = stringToBeProcessed.length();
        long totalSum = N * (N + 1) / 2;
        for (String s : arr) {
            totalSum -= (long) s.length() * (s.length() + 1) / 2;
        }
        System.out.println(totalSum);

    }

    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int numberOfTestCases = Integer.parseInt(br.readLine());
        if (numberOfTestCases >= 1 && numberOfTestCases <= 1000) {
            for (int i = 0; i < numberOfTestCases; i++) {
                currentLengthOfString = Integer.parseInt(br.readLine());
                if (currentLengthOfString >= 1 && currentLengthOfString <= 1_000_000) {
                    String[] stringArr = br.readLine().split(" ");
                    stringToBeProcessed = stringArr[0];
                    stringToBeFind = stringArr[1];
                    findNumberOfStrings();
                }

            }
        }

    }
}
