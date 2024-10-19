import java.util.*;
public class Main {
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] split = s.split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparable::compareTo);
        for (String s : list) {
            System.out.println(s + " " + map.get(s));
        }
    }
}