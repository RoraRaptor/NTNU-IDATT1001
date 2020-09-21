package Test;

public class Test {

    public static void main(String[] args) {
//        System.out.println((0.00000000000000000000 % 1 == 0));

        int[] distribution = {1, 2, 3, 4};

        for (int i = 0; i < distribution.length; i++) {
            System.out.printf("%c: %d\n", (char) (65 + i), distribution[i]);
        }
    }
}
