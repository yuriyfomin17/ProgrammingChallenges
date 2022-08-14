package problems.IncreasingArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String N = br.readLine();
        String info = br.readLine();
        int[] arr = Arrays.stream(info.split(" ")).mapToInt(Integer::parseInt).toArray();
        increasingArray(arr);
    }

    public static void increasingArray(int[] arr) {
        long count = 0;
        MyQueue queue = new MyQueue();
        int idx = 0;
        while (idx < arr.length) {
            queue.add(arr[idx++]);
            if (queue.size() == 2) {
                int firstElem = queue.poll();
                int secElem = queue.peek();
                if (secElem < firstElem) {
                    count += firstElem - secElem;
                    queue.add(queue.poll() + (firstElem - secElem));
                }
            }
        }
        System.out.println(count);

    }

    static class MyQueue {
        private int N = 0;
        private Node head;
        private Node tail;

        public void add(int num) {
            if (isEmpty()) {
                head = new Node(num);
                tail = head;
            } else {
                tail.nexNode = new Node(num);
                tail = tail.nexNode;
            }
            N++;

        }
        public int poll(){
            if (head == null) return 0;
            int value = head.num;
            head = head.nexNode;
            N--;
            return value;
        }
        public int peek(){
            if (head == null) return 0;
            return head.num;
        }
        public int size(){
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }
    }

    static class Node {
        private final int num;
        private Node nexNode = null;

        public Node(int num) {
            this.num = num;
        }
    }
}
