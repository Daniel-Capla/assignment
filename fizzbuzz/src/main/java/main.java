public class main {

    public static void main(String[] args) {
        countFizzBuzz(2,7,15);
    }
    private static void countFizzBuzz(int x, int y, int n) {
        for (int i = 1; i <= n; i++) {
            if (i % x == 0 && i % y == 0) {
                System.out.print("FB ");
            } else if (i % y == 0) {
                System.out.print("B ");
            } else if (i % x == 0) {
                System.out.print("F ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
