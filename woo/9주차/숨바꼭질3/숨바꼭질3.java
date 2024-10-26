import java.util.*;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static int[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[2_00_000];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[N] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int idx = poll.idx;
            int value = poll.value;
            if (idx == K) break;
            // + 1 , - 1, * 2 를 갈 수 있음
            if (idx < 1_00_000 && map[idx + 1] > value) {
                map[idx + 1] = value + 1;
                q.add(new Node(idx + 1, value + 1));
            }

            if (idx > 0 && map[idx - 1] > value) {
                map[idx - 1] = value + 1;
                q.add(new Node(idx - 1, value + 1));
            }

            if (idx < 1_00_000 && map[idx * 2] > value) {
                map[idx * 2] = value;
                q.add(new Node(idx * 2, value));
            }
        }
        System.out.println(map[K]);
    }

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}