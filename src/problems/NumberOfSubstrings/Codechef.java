package problems.NumberOfSubstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codechef {
    static String stringToBeProcessed;
    static String stringToBeFind;
    static int currentLengthOfString;

    public static void findNumberOfStrings() {
        String[] arr = stringToBeProcessed.split(stringToBeFind);
        int N = stringToBeProcessed.length();
        int totalSum = N * (N + 1) / 2;
        int sumOfStringsWitoutNeededStrings = 0;
        for (String s : arr) {
            sumOfStringsWitoutNeededStrings += s.length() * (s.length() + 1) / 2;
        }
        totalSum -= sumOfStringsWitoutNeededStrings;
        System.out.println(totalSum);

    }

    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int numberOfTestCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            currentLengthOfString = Integer.parseInt(br.readLine());
            String[] stringArr = br.readLine().split(" ");
            stringToBeProcessed = stringArr[0];
            stringToBeFind = stringArr[1];
            findNumberOfStrings();
        }
    }
}
