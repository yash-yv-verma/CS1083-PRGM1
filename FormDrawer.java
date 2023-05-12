import java.util.*;

public class FormDrawer{

  public static Scanner scnr = new Scanner(System.in);

  public static void showMenu(){
    System.out.println("Please, select one of the following options");
    System.out.print("0. Exit\n1. Draw a Diamond\n2. Draw a Rectangle\n3. Draw a Triangle\n");
  }

  public static void getMenuSelection(){
    showMenu();
    int choice = scnr.nextInt();
    
    if(choice == 0){
      System.out.println("Thank you for using the formDrawer program, Good bye!");
    }else if(choice == 1){
      diamond();
    }else if(choice == 2){
      rectangle();
    }else if(choice == 3){
      triangle();
    }else{System.out.println("Incorrect option, please try again"); getMenuSelection();}
  }


  public static void diamond(){

    System.out.println("Please write the char that you would like to be used to fill the diamond");
    char fillChar = scnr.next().charAt(0);

    System.out.println("Please write the char that you would like to be used as edge of the diamond");
    char edgeChar = scnr.next().charAt(0);

    System.out.println("What size do you want the diamond to be drawn?");
    System.out.println("Please insert an even number between 0 and 60");
    int size = scnr.nextInt();
    while(size < 0||size > 60 || size % 2 != 0){
      System.out.println("What size do you want the diamond to be drawn?");
    System.out.println("Please insert an even number between 0 and 60");
      size = scnr.nextInt();
    }
    
    drawDiamond(fillChar, edgeChar, size);
    getMenuSelection();
  }
  public static void drawDiamond(char fillChar, char edgeChar, int size){
  
    int j = 0;
    for(int i = (size/2); i > 0; i--){
      showCharNTimes(edgeChar, (i - 1));
      showCharNTimes('/', 1);
      showCharNTimes(fillChar, j*2);
      showCharNTimes('\\', 1);
      showCharNTimes(edgeChar, (i - 1));
      showCharNTimes('\n', 1);
      j++;
    }

    j = size / 2;
    for(int i = 0; i < (size/2); i++){
      showCharNTimes(edgeChar, (i));
      showCharNTimes('\\', 1);
      showCharNTimes(fillChar, (j*2)-2);
      showCharNTimes('/', 1);
      showCharNTimes(edgeChar, (i));
      showCharNTimes('\n', 1);
      j--;
    }

  }

  public static void showCharNTimes(char c, int n){
    for(int i = 0; i < n; i++){
      System.out.print(c);
    }
  }

  
  
  public static void rectangle(){

    System.out.println("Please write the char that you would like to be used as the contour of the rectangle");
    char chr = scnr.next().charAt(0);

    System.out.println("Do you want the rectangle to be printed hollow?");
    char empty = scnr.next().charAt(0);
    boolean hollow = false;
    while(empty != 'Y' && empty != 'N'){
      System.out.println("Incorrect option, please try again");
      System.out.println("Do you want the rectangle to be printed hollow?");
      empty = scnr.next().charAt(0);
        
      }
        
        if(empty == 'Y'){  hollow = true;}
        else if(empty == 'N'){  hollow = false;}
        

    System.out.println("What size do you want the Rectangle to be drawn?");
    System.out.println("Please insert any number between 0 and 60");
    int size = scnr.nextInt();

    while(size < 0 || size > 60){
    System.out.println("What size do you want the Rectangle to be drawn?");
    System.out.println("Please insert any number between 0 and 60");
      size = scnr.nextInt();
    }

    drawRectangle(chr,size,hollow);

    getMenuSelection();
  
}


  

  public static void drawRectangle(char chr, int size, boolean hollow){
    if(!hollow){
       for(int i = 0; i <= size; i++){
          drawRectangleLine(chr,size,false);
       }
   }else{
      drawRectangleLine(chr,size,false);
      for(int i = 0; i < size - 2; i++){
        drawRectangleLine(chr,size,true);
      }
      drawRectangleLine(chr,size,false);
   }
}




  
  public static void drawRectangleLine(char chr, int size, boolean hollow){
    
    if(hollow){
      System.out.print(chr);
      for(int i = 1; i < size - 1; i++){
        System.out.print(' ');
      }
      System.out.print(chr);
      System.out.println();
    }else {
      for(int i = 0; i < size; i++){
        System.out.print(chr);
      }
    System.out.println();
      
    }   
}
  
  
  
  public static void triangle(){
    
    System.out.println("What size do you want the triangle to be drawn?");
    System.out.println("Please insert an even number between 0 and 60");
    int width = scnr.nextInt();
    while(width < 0 || width > 60 || width % 2 != 0){
      System.out.println("What size do you want the triangle to be drawn?");
      System.out.println("Please insert an even number between 0 and 60");
      width = scnr.nextInt();
    }
    drawTriangle(width);
    getMenuSelection();
  }


  public static void drawTriangle(int width){
    for(int i = 0; i < width/2 ; i++){
      for(int j = (width/2) - i; j > 0; j-- ){
        System.out.print(" ");
      }
    System.out.print("/");

      for(int s = 0; s < (i*2); s++){
        System.out.print(" ");
      }

      System.out.print("\\");
      System.out.println();
      
    }
    System.out.print(" ");
    for(int x = 0; x < width; x++){
      System.out.print("-");
    }
    System.out.println();
    
  }

  
    public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Fall 2022 - CS1083 - Section 001 - Project 2 - FormDrawer - written by Yash Verma\n");
    getMenuSelection();
  }
  
  

}

