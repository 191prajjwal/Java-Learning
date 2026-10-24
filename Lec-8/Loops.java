public class Loops{
    public static void main(String [] args){

// for doing a task again and again until a condition follows we use loop

//inside condition of loops the expression must evaluate to boolean only

       //While loop

       int i=1;
       while(i<=10){
        System.out.println(i);
        i++;
       }

    //    we can write same above thing more cleanly like 

    int j=1;
    while(j<=10){
        System.out.println(j++);
    }


    // do-while loop
    //it will run atleast once and then check condition is true or not 

    int k=1;

    do{
        System.out.println(k);
        k++;
    }while(k<=10);



    //For loop
    
    int l;

    for(l=0;l<5;l++){
       System.out.println(l);
    }


    // we can do it more cleanly by initializing the loop variable inside for only

    for(int m=0;m<5;m++){
        System.out.println(m);
    }


    //Infinite loop situations

int n=1;
    while( n<=5){
System.out.println("Hello");
    }


//     for(int o=1; ;o++){
// System.out.println("Hello");
//     }

   
//  for(;;){
//         System.out.println("Hello");
//     }
    
    //in for loop iniitialization condition and increment all maybe left empty it will be an inf loop too.


    for(int q=1,r=0;q<4;q++,r=r+2 ){
       System.out.println(q+r);
    }

    //we can write comma separated values of same type and initialize them once in a for loop, the condtions can not be comma separated we have to use && || or any other logical operator only, the increment can be comma separated as well
   





        
    }
}