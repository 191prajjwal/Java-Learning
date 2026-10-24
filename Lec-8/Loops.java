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






        
    }
}