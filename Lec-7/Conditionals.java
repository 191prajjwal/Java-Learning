public class Conditionals{
    public static void main(String[] args) {
       //in java if else only takes anyy expresssion that finally gives boolean output only (true /false)
       // if(1){} is wrong because we are giving 1 inside if but it only expects boolean values

       boolean cond=true;

       if(cond==true){
        System.out.println("Condition is true");
       }

       System.out.println("Condition is false");

       // once if is evaluated whether control goes inside it or not then it will come out of the if block and execute next
       //here we have another print that says condition is false ebven though it is true because after if block is evaluated control comes out of it and there the second print was evaluated.
       //if we do not want to run 2nd print like this and want it to evaluate only if condition is false then place it inside else

         if(cond==true){
        System.out.println("Condition is true");
       }

       else{
          System.out.println("Condition is false");
       }

       // we can write multiple if one after another , nested ifs and if else ladder as well
       // it  will be clear when we use it while solving any problem so ignoring this right now.

       
     
    }
}