public class Operators {

    public static void print(int a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        // Arithmetic operators (+,-,/,*,%,+=,-=,*=,/=,%=,++,--)
        // Relational Operator(==,!=,<,>,<=,>=) they return boolean answer ==> // true/false

        // BITWISE operators (&,|,~,^,<<,>>,>>>)
        // bitwise AND takes two numbers and do bitwise AND simiarly OR similarly bitwise NOT
        int a =5;//......00000101
        int b=6;//.......00000110
    // BITWISE AND---------------------------------
        int c= a&b;//....00000100
        print(c);// it will give 4 because converting them to binary and doing bitwise AND,  will give 4
  //  BITWISE OR
        int d= a|b;//....000000111;
        print(d);//it will give 7 because converting themk to binary and doing bitwise OR, will give 7

//BITWISE NOT
        //for simpilicity took byte otherwise we have to analyze whole 4B if int was taken
        byte e=2;//00010010;
        e=(byte)~e; //11101101 
        print(e);// converting 11101101 in int it will be -11
        // I found out that it gives -(value+1) in result if value was 2 it will give -(2+1)= -1 and it  vaue was -4 it will give -(-4+1) = +3

//BITWISE XOR==> it will take two bits and see if odd no. bits(either of them is one but not both) are 0 then it give 1 else gives 0.

        byte f=5;          //00000101
        byte g=6;          //00000110
        byte h=(byte)(f^g);//00000011

        print(h);   //it will give 3 as output

//LEFT SHIFT OPERATOR (<<)

        byte i=5;//00000101 try for -5 as well.
        i=(byte)(i<<1); // 0 00001010 so each bit is sfited towards left one time, shifting towards  left once, means each bit is multiplied by 2 to the power 1.  so left shift by 1 means in integer we are multiplying it with 2 to the pow 1.and in the remaining right places  it  always  fills 0.
        print(i);// it will print 10;

        //both operands in shit operators must be integers only. if they are not then make it explicitely using typecasting.


//Signed Right Shift operator(>>)

        byte j=5;//00000101;
        j=(byte)(j>>1);//00000010 so 1 LSB bit is cut and since number was +ve 0 is placed i n MSB
        print(j);// it will print  2;

        byte k=-5;// 11111011 this is -5 in 2's compl representation
        k=(byte)(k>>1);//11111101 so this is signed right shift operator so it will shift LSB by 1 to right and in MSB it will place the sign since it was -ve it placed 1.
        print(k); //it will print -3

        // for +ve numbers it is like integer division by 2 to the power x and for -ve numbers it is will give - Ceil(number diivded by 2 to the power x)



//Unsigned Right Shift operator(>>>)

int l=5;//0000.....00000101
l=(l>>>1);// 00000......00000010// each bit shifted to right once hence LSB is gone and MSB has empty place that is filled by 0.
print(l);

// for +ve numbers it behaves exactly same as signed right shift operator because it always place 0's in MSB when shift is done.
// so it will print 2 .

int m= -5;//1111......11111011
m=(int)(m>>>1);// 01111......11111101 so each bit is shifted to right once hence LSB is gone and empty MSB is filled with 0.
print(m);// so it will print a huge number 2147483645





    }
} 