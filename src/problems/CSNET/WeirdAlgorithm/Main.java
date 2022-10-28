package problems.CSNET.WeirdAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        solution(n);
    }
    public static void solution(long inputNum){
        List<Long> arrResult = new ArrayList<>();
        arrResult.add(inputNum);
        while (inputNum != 1){
            if (inputNum % 2 == 0){
                inputNum /= 2;
            }
            else if (inputNum % 2 != 0) {
                inputNum *= 3;
                inputNum += 1;
            }
            arrResult.add(inputNum);
        }
        String res = arrResult.stream().map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
