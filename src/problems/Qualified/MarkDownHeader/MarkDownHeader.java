package problems.Qualified.MarkDownHeader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MarkDownHeader {
    public static String convertToHTML(String input){
        String[] arr = input.split(" ");
        if (!containsJustHash(arr[0])) return input;
        ArrayList<String> wordArr = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (!justWord(arr[i])) return input;
            else {
                wordArr.add(arr[i]);
            }
        }
        int lengthHashes = arr[0].length();

        return "<h" + lengthHashes + ">" + wordArr.stream().collect(Collectors.joining(" ")) + "</h" + lengthHashes + ">";
    }

    public static boolean containsJustHash(String hString){
        String[] arrH = hString.trim().split("");
        for (String s: arrH ){
            if (!s.equals("#")) return false;
        }
        return true;
    }

    public static boolean justWord(String word){
        return !word.trim().contains("#");
    }

    public static void main(String[] args) {
        System.out.println(convertToHTML("# header"));
        System.out.println(convertToHTML("# header"));
        System.out.println(convertToHTML("## smaller header"));
        System.out.println(convertToHTML("#Invalid"));
    }
}
