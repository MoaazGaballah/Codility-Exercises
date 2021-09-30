public class ArrListLen {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int index = 0;
        int count = 0;
        for (int elemenet : A) {
            count++;
            if (A[index] == -1)
                break;
            index = A[index];
        }

        return count;
    }

    public static void main(String[] args) {
        int A[] = {1, 4, -1, 3, 2};

        System.out.println(solution(A));
    }
}
