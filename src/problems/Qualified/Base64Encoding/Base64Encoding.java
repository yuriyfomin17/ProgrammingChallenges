package problems.Qualified.Base64Encoding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Base64Encoding {
//    private static String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".split("");
//    public static String encodeToBade64(String inputString) {
//        Queue<String> queue = new ArrayDeque<>();
//        String[] bytes;
//        for (Character elem : inputString.toCharArray()) {
//            if (elem == ' ') {
//                 bytes = ("0" + Integer.toBinaryString(65)).split("");
//            }else {
//                String[] bytes = ("0" + Integer.toBinaryString(elem)).split("");
//            }
//
//            queue.addAll( Arrays.asList( bytes));
//        }
//        ArrayList<String> res = new ArrayList<>();
//        StringBuilder currentString = new StringBuilder();
//        while (queue.size() != 0){
//            currentString.append(queue.poll());
//            if (currentString.length() == 6) {
//                int number = getNumberFromByteString(currentString.toString());
//                res.add(alphabet[number]);
//                currentString = new StringBuilder();
//            } else if (queue.size() == 0 && currentString.length() != 6){
//                while (currentString.length() != 6) currentString.append("0");
//                int number = getNumberFromByteString(currentString.toString());
//                res.add(alphabet[number]);
//                currentString = new StringBuilder();
//            }
//        }
//
//        return res.stream().collect(Collectors.joining(""));
//    }
//
//    public static int getNumberFromByteString(String string) {
//        String[] bitString = string.split("");
//        int sum = 0;
//        int idx = 0;
//        for (int i = bitString.length - 1; i >= 0; i--) {
//            int incrementor = (int) Math.pow(2, idx++);
//            if (bitString[i].equals("0")) continue;
//            sum += incrementor;
//        }
//        return sum;
//    }
//    // Encodes a URL to a shortened URL.
//
//
//    // Decodes a shortened URL to its original URL.
//
//
//    public static void main(String[] args) {
//        System.out.println(encodeToBade64("Many hands make light work."));
//        System.out.println(encodeToBade64("this is a string!!"));
//        System.out.println(encodeToBade64("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
//
//    }

    public static String convertToBinary(int input , int blockSize, String result){
        if (blockSize == 0) return result;
        blockSize--;

        int power = (int) Math.pow(2, blockSize);

        if (input >= power){
            result += "1";
            input -= power;
        } else {
            result += "0";
        }
        return convertToBinary(input, blockSize, result);
    }
    public static int ConvertToBase10(String input) {
        int res = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(input.length() - (i + 1)) == '1')
                res += (int)Math.pow(2, i);
        }
        System.out.println(input + "," + res);
        return res;
    }

    public static String convertToBase64(String str){
        String[] alpahbet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".split("");

        StringBuilder binary = new StringBuilder();
        for (char a: str.toCharArray()) {
            if ((int) a >= 0){
                binary.append(convertToBinary(a, 8, ""));
            }
        }
        System.out.println(binary);
        String binaryString = binary.toString();
        StringBuilder result = new StringBuilder();
        while (binaryString.length() > 0){
            if (binaryString.length() >= 6){
                result.append(alpahbet[ConvertToBase10(binaryString.substring(0, 6))]);
                binaryString = binaryString.substring(6);
            } else {
                int numRepeat = 6 - binaryString.length();
                result.append(alpahbet[ConvertToBase10(binaryString + "0".repeat(numRepeat))]);
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase64("this is a string!!"));
        System.out.println(convertToBase64("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
    }
}
