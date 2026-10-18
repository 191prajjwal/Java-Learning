public class Temp{
  public static void main(String[] args){

    //Integer data type
    byte a =6;//1B====> 8 bits
    short b=34;// 2B==> 16 bits
    int c= 55;// 4B==> 32 bits
    long d= 3_48_887;// 8B==>64 bits; we can use in b/w numbers the underscore to make it readable. it is ignored by compiler
    System.out.println("Integer data types ===============> "+a+" "+b+" "+c+" "+d);

    //floating point numbers or numbers

    float e= 12345.88f;//4B single prcision
    double f= 43569.99; // 8B double precision  and by default every decimal number is double precision only so to represent float we use f at last.

    System.out.println("Floating point data types ==========> "+e+" "+f);

    // Character dataType

    char g='1';// it is stored using unicode and it is of 16 bits or 2B 
    char h='a';

    System.out.println("Character data types ===============> "+g+" "+h);


    //boolean datatype

    boolean i= true;// java dont specify size of boolean 
    boolean j= false;

    System.out.println("Boolean data type ===============> "+ i+" "+j);


    //integer data types are stored in 2's complement way means if number is less than 0 it will we converted to 2's complement and stored and it will have MSB 1 so while retriving MSB will tell it is -ve and it will do anti logic to get magnitude. and for +ve number and 0 MSb is fixed to 0 and it is stored as normal binary and while retriving we just see magnitude.

    // for floating point representation using IEEE standard
    // if we store using float data type then in 4B = 32 bits 1 bit is fixed as sign bit 8 bits for exponent and 23bits for mantissa and while retrieving  -1(sign bit)* 1.(mantissa)*2^(exp-bias)

    // similarly double is stored using 8B and hence 1 sign bit 11 exp bit and 52 mantissa bit.
    //double is more precised.





    //
  }
}