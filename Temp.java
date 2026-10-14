public class Temp {
  public static void fibonacci(int n) {
    int prev = 1;
    int secondPrev = 0;

    System.out.print(secondPrev+" ");
    System.out.print(prev+" ");

    for (int i = 3; i <= n; i++) {
      int curr = prev + secondPrev;
      System.out.print(curr+" ");
      secondPrev = prev;
      prev = curr;
    }

  }

  public static void main(String[] args) {

    fibonacci(10);

  }
}