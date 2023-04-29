public class main {

    public static void main(String[] args) {
        System.out.println(countFizzBuzz(2,7,15));
    }
    private static String countFizzBuzz(int x, int y, int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            if (i % x == 0 && i % y == 0) {
                result += "FB ";
            } else if (i % y == 0) {
                result += "B ";
            } else if (i % x == 0) {
                result +="F ";
            } else {
                result += (i + " ");
            }
        }
        return result;
    }
}
