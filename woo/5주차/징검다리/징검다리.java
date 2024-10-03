import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long N = sc.nextLong();
            long ans = 0;
            long start = 1;
            long last= (long) Math.sqrt((2*N-1));
            while (start <= last) {
                long mid = (start + last) / 2;
                long sum=  (mid) *(mid+1)/2;
                if(sum<=N){
                    ans = Math.max(mid, ans);
                    start=mid+1;
                }
                else{
                    last=mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}