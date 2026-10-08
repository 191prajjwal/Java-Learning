public class DataTypes{
    public static void main(String[] args){


        //Variable declaration vs definition(initialization)
        //int a =6; this is declaration and definition at same time
        //int a; this is declaration so 4B memory is allocaated to a but it has no value currently so if we print it it will give compile time error saying a is not initialized yet.
        //a=6; //this is definition

        //the variable name should not be a keyword (java specific words we cant use like int , if , else etc as a variable name)


        //Integer data type
        byte num1= 12;//1B
        short num2=9;//2B
        int num3= -45689;//4B
        long num4=65434984;//8B
         /* we can store binary, octal and hexadecimal also instead of decimal using integer data type so basically convert that in the binary octal and hexadecimal and using corrresponding prefix store it. although on printiong it will show in decimal only*/  
      byte num5=0B1100;//to use binary number we use prefix 0b or 0B
      short num6=011;//to use octal we simply use prefix 0
      int num7= 0XF;//to use hexadecimal  we use prefix 0x or 0X




    // Real / Floating point numbers
    float real1= 44.50099943355668999f;//4B and we have to use word f at last of float else compiler will think it is double value but we are storing it in float so it will give some error.
    double real2= 456666.66666887;//8B 
    //the above representation is called standard way of representing double data
    double real3= 8.044E23;//or 8.044e23 it is scientific representation of double and it means 8.044 * 10^23




    //Character Data type
        char char1= 'a';//2B
        char char2= '*';//2B
        


    //Boolean Data type
        boolean isTrue= false;    //java dont say boolean is 1 bit or 1B because it actuallly depends on jVM




    //in number data types like float , double ,int,nyte,short,long to improve readability we can use underscores only and only b/w two numbers to make it more readable while compiling compiler will ignore underscores
    
    int num8= 1234567;//it is not readable
    int num9= 123__456__7;//we can use any number of underscores in b/w
    double real4= 8.049__994e20;//we cant use __ before or after e and .



    System.out.println("Integer data:---------->   "+ num1+ ", " + num2 + ", "+ num3  + ", "+ num4+", " + num5 + ", "+ num6  + ", "+ num7+" "+num8+" "+num9 );
    System.out.println("Float Data:------>   "+real1+ ", " +real2+", "+real3+real4);
    System.out.println("Character Data:------>    " + char1 + ", "+ char2);
    System.out.println("Boolean Data:------>    " + isTrue);



    }
}