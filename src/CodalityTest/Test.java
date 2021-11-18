package CodalityTest;

public class Test {

    public static int solution(int N, int K) {
        // write your code in Java SE 8

        int minBottles = 0;

        for (int i = N; i > 0; i--) {
            if (i <= K){
                minBottles++;
                K -=i;
            }
            if (K == 0) break;

        }
        if (K != 0) return -1;

        return minBottles;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 2));
    }
}
