public class Temp {
  public static void main(String[] args) {

    byte x = 64;
    x = (byte) (x << 1); //-128 because truncated

    byte y = 64;
    int z = y << 1;//128

    byte a = -128;
    a = (byte) (a << 1);//0 because truncated

    byte b = -128;
    int c = b << 1;//-256

    System.out.println(x + " " + z + " " + a + " " + c);

  }
}