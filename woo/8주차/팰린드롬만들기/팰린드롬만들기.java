public class Main {
    private static final String SRY = "I'm Sorry Hansoo";
    private static final Set<String> set = new HashSet<>();
    private static int[] arr;
    private static int oddIdx;
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        char[] charArray = N.toCharArray();
        if (!canPalindrome(charArray)) {
            System.out.println(SRY);
            return;
        }
        boolean[] v = new boolean[charArray.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        String string = sb.toString();
        if (cnt == 1) {
            string += ((char) (oddIdx + 'A'));
        }
        string += sb.reverse();
        System.out.println(string);
    }

    private static boolean canPalindrome(char[] chars) {
        arr = new int[26];

        for (char aChar : chars) {
            arr[aChar - 'A']++;
        }
        cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                cnt++;
                oddIdx = i;
            }
        }
        return cnt < 2;
    }
}