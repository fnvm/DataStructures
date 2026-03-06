import java.util.Scanner;

public class Task {
  static long gcd(long a, long b, long[] res) {
    // Базовый случай
    if (b == 0) {
      res[0] = 1;
      res[1] = 0;
      return a;
    }

    long[] temp = new long[2];
    long d = gcd(b, a % b, temp);

    res[0] = temp[1];
    res[1] = temp[0] - (a / b) * temp[1];

    return d;
  }

  public static void main(String[] args) {
    String greeting =
        "Лазарев Владимир, РПИб"
            + System.lineSeparator()
            + "Нахождение НОД и соотношения Безу"
            + System.lineSeparator()
            + "-------------"
            + System.lineSeparator();

    System.out.println(greeting);

    try (Scanner in = new Scanner(System.in)) {
      System.out.print("Value of a: ");
      long a = in.nextLong();

      System.out.print("Value of b: ");
      long b = in.nextLong();

      System.out.println();

      long[] res = new long[2];

      // Таймер выполнения алгоритма
      long start = System.nanoTime();
      long d = gcd(a, b, res);
      long end = System.nanoTime();

      System.out.printf("GCD: %d, x = %d, y = %d%n", d, res[0], res[1]);
      System.out.printf("Execution time: %.6f ms%n", (end - start) / 1_000_000.0);
    }
  }
}
