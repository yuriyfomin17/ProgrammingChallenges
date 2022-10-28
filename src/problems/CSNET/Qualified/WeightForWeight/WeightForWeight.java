package problems.CSNET.Qualified.WeightForWeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WeightForWeight {
    // "56 65 74 100 99 68 86 180 90"
    //"100 180 90 56 65 74 68 86 99"
    public static String sortByWeight(String inputString){
        String[] numStringArr = inputString.trim().split(" ");
        Function<String, Integer> weightComparator = (s) -> Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();

        List<String> res = Arrays.stream(numStringArr).sorted(Comparator.comparing(weightComparator).thenComparing(Function.identity())).collect(Collectors.toList());
        return res.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(sortByWeight("56 65 74 100 99 68 86 180 90")); // "100 180 90 56 65 74 68 86 99"
        System.out.println(sortByWeight("103 123 4444 99 2000")); // "2000 103 123 4444 99"
        System.out.println(sortByWeight("2000 10003 1234000 44444444 9999 11 11 22 123")); // "11 11 2000 10003 22 123 1234000 44444444 9999"
    }

}
