import java.util.*;
import java.awt.*;

public class SyncedForms {
  
  public static void drawSyncedForms() { //This method creates the drawing panel and asks user for all input needed.
    Scanner scnr = new Scanner(System.in); // Also prints name.^
    int[] xPos = new int[9];
    int[] yPos = new int[9];
    Color[] typeOfColor = new Color[9];
   
    DrawingPanel panelWindow = new DrawingPanel(400, 400);
    Graphics g = panelWindow.getGraphics();
    
    
    System.out.print("What form will be shown (C-circle, S-square)");
    char shapeChar = scnr.next().charAt(0);
    
    System.out.print("How many forms you want to show (max 9)");
    int numOfForms = scnr.nextInt();
    
    System.out.print("How many times you want the forms to move (max 500)?");
    int numOfMoves = scnr.nextInt();
    
    
    initialPosition(xPos, yPos, numOfForms);
    initialColor(typeOfColor, numOfForms);
    
    //System.out.print("Please, ");
    
    moveForms(panelWindow, shapeChar, xPos, yPos, typeOfColor, numOfForms, numOfMoves);
    
    g.setColor(Color.BLACK);
    g.fillRect(15, 170, 350, 50);
    g.setColor(Color.GREEN);
    g.drawRect(15, 170, 350, 50);
    g.drawString("UTSA - Fall 2022 - CS1083 - Section 001 - Project 3 - ", 20, 190);
    g.drawString("SyncedForms - Written by Yash Verma ", 20, 210);
    
  }
  
  public static void initialPosition(int[] xPosOfForm, int[] yPosOfForm, int numOfForms) { //The positions are set int this method all the coordinates are set respectively.
    Random rand = new Random();
    int num;
    for (int i = 0; i < numOfForms; i++) {
      num = rand.nextInt(numOfForms + 2);
      switch(num){
        case 0:
          xPosOfForm[i] = 75;
          yPosOfForm[i] = 75;
          break;
        case 1:
          xPosOfForm[i] = 275;
          yPosOfForm[i] = 75;
          break;
        case 2:
          xPosOfForm[i] = 275;
          yPosOfForm[i] = 275;
          break;
        case 3:
          xPosOfForm[i] = 75;
          yPosOfForm[i] = 275;
          break;
        case 4:
          xPosOfForm[i] = 175;
          yPosOfForm[i] = 175;
          break;
        case 5:
          xPosOfForm[i] = 75;
          yPosOfForm[i] = 175;
          break;
        case 6:
          xPosOfForm[i] = 275;
          yPosOfForm[i] = 175;
          break;
        case 7:
          xPosOfForm[i] = 175;
          yPosOfForm[i] = 75;
          break;
        case 8:
          xPosOfForm[i] = 175;
          yPosOfForm[i] = 275;
          break;
      }

    }
   
    for (int j = 0; j < numOfForms; j++) {
      switch(j){
        case 0:
          yPosOfForm[j] = 75;
          break;
        case 1:
          yPosOfForm[j] = 75;
          break;
        case 2:
          yPosOfForm[j] = 275;
          break;
        case 3:
          yPosOfForm[j] = 275;
          break;
        case 4:
          yPosOfForm[j] = 175;
          break;
        case 5:
          yPosOfForm[j] = 175;
          break;
        case 6:
          yPosOfForm[j] = 175;
          break;
        case 7:
          yPosOfForm[j] = 75;
          break;
        case 8:
          yPosOfForm[j] = 275;
          break;
      }
      
     
    }
 }
  
  
  public static void initialColor(Color[] formColors, int numOfForms) {//This method random randomly selects color.
    Random rand = new Random();
    int randNum;
    for (int a = 0; a < numOfForms; a++) {
      randNum = rand.nextInt(9);
      if (a == 0) {
        formColors[randNum] = Color.GREEN;
      }
      else if (a == 1) {
        formColors[randNum] = Color.GRAY;
      }
      else if (a == 2) {
        formColors[randNum] = Color.YELLOW;
      }
      else if (a == 3) {
        formColors[randNum] = Color.RED;
      }
      else if (a == 4) {
        formColors[randNum] = Color.ORANGE;
      }
      else if (a == 5) {
        formColors[randNum] = Color.PINK;
      }
      else if (a == 6) {
        formColors[randNum] = Color.DARK_GRAY;
      }
      else if (a == 7) {
        formColors[randNum] = Color.BLUE;
      }
      else if (a == 8) {
        formColors[randNum] = Color.BLACK;
      }
    }
  }
  
  
  public static void moveForms(DrawingPanel panel, char shapeChar, int[] xPosOfForm, int[] yPosOfForm, Color[] formColors, int numOfForms, int numOfDiffMoves) {//This method uses for loops which take in respective values and respective values are used in other method inside a for loop to show.
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    for (int p = 0; p < numOfForms; p++) {
      showForm(panel, shapeChar, xPosOfForm[p], yPosOfForm[p], formColors[p], 50);
    }
    
    for (int l = 0; l < numOfDiffMoves; l++) {
      int orientationNum = rand.nextInt(8);
      moveForm(xPosOfForm, yPosOfForm, 25, orientationNum);
      for (int v = 0; v < numOfForms; v++) {
        showForm(panel, shapeChar, xPosOfForm[v], yPosOfForm[v], formColors[v], 50);
      }
      panel.sleep(50);
    }
  }
  
  public static void moveForm(int[] xPosOfForm, int[] yPosOfForm, int formValue, int orientationNum) {//This method sets the x and y position based the orientation number.
    if (orientationNum == 0) {
      for (int n = 0; n < yPosOfForm.length; n++) {
        yPosOfForm[n] = yPosOfForm[n] - formValue;
      }
    }else if (orientationNum == 1) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] + formValue;
      }
      for (int n = 0; n < yPosOfForm.length; n++) {
        yPosOfForm[n] = yPosOfForm[n] - formValue;
      }
    }else if (orientationNum == 2) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] + formValue;
      }
    }else if (orientationNum == 3) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] + formValue;
      }
      for (int n = 0; n < yPosOfForm.length; n++) {
        yPosOfForm[n] = yPosOfForm[n] + formValue;
      }
    }else if (orientationNum == 4) {
      for (int n = 0; n < yPosOfForm.length; n++) {
        yPosOfForm[n] = yPosOfForm[n] + formValue;
      }
    }else if (orientationNum == 5) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] - formValue;
      }
      for (int n = 0; n < yPosOfForm.length; n++) {
        yPosOfForm[n] = yPosOfForm[n] + formValue;
      }
    }else if (orientationNum == 6) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] - formValue;
      }
    }else if (orientationNum == 7) {
      for (int n = 0; n < xPosOfForm.length; n++) {
        xPosOfForm[n] = xPosOfForm[n] - formValue;
      }
      for (int z = 0; z < yPosOfForm.length; z++) {
        yPosOfForm[z] = yPosOfForm[z] - formValue;
      }
    }
  }
  
  public static void showForm(DrawingPanel panel, char formsShown, int xPosFormValue, int yPosFormValue, Color color, int formSize) {//This method checks whether the form is a circle or square and based on that it calls methods.
    Graphics showFormGraphics = panel.getGraphics();
    
    if (formsShown == 'C'){
      showFormGraphics.setColor(color);
      showFormGraphics.fillOval(xPosFormValue, yPosFormValue, formSize, formSize);
      showFormGraphics.setColor(Color.BLACK);
      showFormGraphics.drawOval(xPosFormValue, yPosFormValue, formSize, formSize);
    }else if (formsShown == 'S'){
      showFormGraphics.setColor(color);
      showFormGraphics.fillRect(xPosFormValue, yPosFormValue, formSize, formSize);
      showFormGraphics.setColor(Color.BLACK);
      showFormGraphics.drawRect(xPosFormValue, yPosFormValue, formSize, formSize);
    }
  }
  
  public static void main(String[] args) {//This is the main which prints my info and later calls drawSyncedForms.
    
    System.out.println("UTSA – Fall 2022 - CS1083 - Section 001 - Project 3 - SyncedForms - written by Yash Verma");
    System.out.println("");
    drawSyncedForms();
  }
}
