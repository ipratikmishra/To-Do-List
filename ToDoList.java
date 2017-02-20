import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList{
  static String filename = "to-do.txt";
  public static void main(String[] args) throws IOException{
    int code = -1;
    do{
    System.out.println("***Welcome to To-Do List App***");
    System.out.println("***     By Pratik Mishra    ***");
    System.out.println("*******************************");
    System.out.println("1. Show all the lists");
    System.out.println("2. Add a task to the list");
    System.out.println("3. Delete a task from the list");
    System.out.println("4. Press 0 to end the app");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a choice : ");
    code = input.nextInt();
    System.out.println();
    switch(code){
      case 1:
        showList();
        System.out.println();
        break;
      case 2:
        System.out.print("Enter a task: ");
        addList();
        break;
      case 3:
        System.out.print("Which task do you want to delete : ");
        int num = input.nextInt();
        deleteList(num);
        break;
      case 0:
        break;
      default:
        System.out.println("Wrong code entered.");
      }
    }while(code!=0);
  }
  static void showList() throws IOException{
    Scanner inFile = new Scanner(new FileReader(filename));
    String task;
    int number = 1;
    while(inFile.hasNext()){
      task = inFile.nextLine();
      System.out.print(number + ". " + task);
      ++number;
      System.out.println();
    }
    inFile.close();
  }
  static void addList() throws IOException{
    PrintWriter outfile = new PrintWriter(new FileWriter(filename, true));
    Scanner input = new Scanner(System.in);
    String list = input.nextLine();
    outfile.println(list);
    outfile.close();
  }
  static void deleteList(int num) throws IOException{
    Scanner inFile = new Scanner(new FileReader(filename));
    ArrayList<String> tasks = new ArrayList<String>();
    while(inFile.hasNext()){
      String task = inFile.nextLine();
      tasks.add(task);
    }
    PrintWriter outfile = new PrintWriter(new FileWriter(filename));
    for(int i=0; i<tasks.size(); i++){
      if((i+1)!=num){
        outfile.println(tasks.get(i));
        System.out.println();
      }
    }
    outfile.close();
  }
}