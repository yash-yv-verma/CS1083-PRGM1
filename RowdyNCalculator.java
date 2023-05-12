import java.util.*;

public class RowdyNCalculator{
  public static void main(String[] args) {
    System.out.println("UTSA - FALL 2022 - CS1083 - Section 001 - Project I - RowdyNCalculator - written by Yash Verma" );
    
    //declaring vars:
    int perform;
    char dataType;
    int int1;
    int int2;
    char operator;
    double doub1;
    double doub2;
    double finalSum = 0;
    
    //Calling scanner
    Scanner scnr = new Scanner(System.in);
    
    //Prompting num times user wants to perform task 
    System.out.print("Please, input the number of calculations you want to perform: ");
    perform = scnr.nextInt();
    
    //Using  prompt to iterate the calculator
    for(int i = 1; i <= perform; i++){ 
      
      System.out.println("Operation number " + i);
      // Prompting computing datatype
      System.out.print("Please, select your choice of datatype of operation (i-integer,d-double): ");
      dataType = scnr.next().charAt(0);
      //Condition checking for which datatype to use
      if (dataType == 'i'){          //INTEGER
        
        System.out.print("Please, input the first integer value: " );
        int1 = scnr.nextInt();
        
        System.out.print("Please, input the character of the operation (+, -, *, /, %): ");
        operator = scnr.next().charAt(0);
        
        System.out.print("Please, input the second integer value: " );
        int2 = scnr.nextInt();
        //checking for which operater was prompeted to run that operation, in integer
        if (operator == '+'){
          finalSum = finalSum + (int1 + int2);
          System.out.println("The result of adding " + int1 + " plus " + int2 + " is: " +     (int1+int2));
        }else if(operator == '-'){
          finalSum = finalSum + (int1 - int2);
          System.out.println("The result of subtracting " + int1 + " minus " + int2 + " is: " +     (int1-int2)); 
        }else if(operator == '/'){
          finalSum = finalSum + (int1/int2);
          System.out.println("The result of dividing " + int1 + " by " + int2 + " is: " +     (int1/int2)); 
        }else if(operator == '*'){
          finalSum = finalSum + (int1*int2);
          System.out.println("The result of multiplying " + int1 + " times " + int2 + " is: " +     (int1*int2)); 
        }else if(operator == '%'){
          finalSum = finalSum + (int1%int2);
          System.out.println("The result of modulo operation of " + int1 + " by " + int2 + " is: " +     (int1%int2)); 
        }else{ 
          System.out.println("Wrong operation");
        }
        //Condition checking for which datatype to use  
      }else if (dataType == 'd'){      // DOUBLE
        
        System.out.print("Please, input the first double value: " );
        doub1 = scnr.nextDouble();
        
        System.out.print("Please, input the character of the operation (+, -, *, /, %): ");
        operator = scnr.next().charAt(0);
        
        System.out.print("Please, input the second double value: " );
        doub2 = scnr.nextDouble();
        //checking for which operater was prompeted to run that operation, in double.
        if (operator == '+'){
          finalSum = finalSum + (doub1 + doub2);
          System.out.println("The result of adding " + doub1 + " plus " + doub2 + " with only 3 decimals is: " + String.format("%.3f",(doub1+doub2)));
        }else if(operator == '-'){
          finalSum = finalSum + (doub1 - doub2);
          System.out.println("The result of subtracting " + doub1 + " minus " + doub2 + " with only 3 decimals is: " +     String.format("%.3f",(doub1-doub2))); 
        }else if(operator == '/'){
          finalSum = finalSum + (doub1 / doub2);
          System.out.println("The result of dividing " + doub1 + " by " + doub2 + " with only 3 decimals is: " +     String.format("%.3f",(doub1/doub2))); 
        }else if(operator == '*'){
          finalSum = finalSum + (doub1 * doub2);
          System.out.println("The result of multiplying " + doub1 + " times " + doub2 + " with only 3 decimals is: " + String.format("%.3f",(doub1*doub2))); 
        }else if(operator == '%'){
          finalSum = finalSum + (doub1 % doub2);
          System.out.println("The result of modulo operation of " + doub1 + " by " + doub2 + " with only 3 decimals is: " + String.format("%.3f",(doub1%doub2))); 
        }else{
          System.out.println("Wrong operation"); //if operation is input wrong
        }
        
      }else{
        System.out.println("Wrong datatype");  //if datatype is input wrong  
      }
      /*When for loops iterates fully, here it checks that and implents thanking and the resulting sum of all
       calculations done code */
      if(i == perform){
        System.out.println("Thank you for using the RowdyNCalculator!");
        System.out.print("The sum of the result of all " + i + " operations is: " + String.format("%.3f",finalSum));
      }
      
    }
    
    
    
  }
}
