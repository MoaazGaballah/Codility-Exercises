import java.util.Arrays;

public class CountBoundedSlices {

    public static class Slice {

        int P;
        int Q;

        public Slice(int P, int Q){
            this.P = P;
            this.Q = Q;
        }
    }
    public static int solution(int K, int[] A) {
        // write your code in Java SE 8

        int count = 0;
        for (int P = 0; P < A.length; P++) {
            for (int Q = P; Q < A.length; Q++) {
                if (max(A, new Slice(P, Q)) - min(A, new Slice(P, Q)) <= K)
                    count++;
            }
        }
        return count;
    }

    public static int max(int [] A, Slice slice){
        A = Arrays.copyOfRange(A, slice.P, slice.Q + 1);
        Arrays.sort(A);
        return A[A.length - 1];
    }

    public static int min(int [] A, Slice slice){
        A = Arrays.copyOfRange(A, slice.P, slice.Q + 1);
        Arrays.sort(A);
        return A[0];
    }

    public static void main(String[] args) {

        int A[] = {3, 5, 7, 6, 3};

        System.out.println(solution(2, A));


//        // test max and min methods
//        System.out.println(max(A, new Slice(1, 3)));
//        System.out.println(min(A, new Slice(1, 3)));
    }
}
