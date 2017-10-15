package com.company;

import java.util.Scanner;
import java.util.Stack;

public class EditorMethods {
    private static Stack<String>  item = new Stack<>();
    private static boolean check=false;

    private  static void add(Stack<String>item) {
        System.out.println("Add  items, when you are done press any method. ");
        System.out.println("(add || copy || delete || undo || quit )" );
        Scanner scan=new Scanner(System.in);

        for (int i=0; i<10;i++) {
            String newItem=scan.nextLine();
            item.push(newItem);

            if (newItem.equalsIgnoreCase("add")){
                item.pop();
                add(item);
            }

            if (newItem.equalsIgnoreCase("copy")){
                item.pop();
                copy(item);

            }
             if (newItem.equalsIgnoreCase("delete")){
                item.pop();
                delete(item);

            }
            if (newItem.equalsIgnoreCase("undo")){
                item.pop();
                undo(item);

            }
            if (newItem.equalsIgnoreCase("quit")){
                item.pop();
                quitProgram();

            }

            System.out.println(newItem);
        }


    }

    public static void startProgram() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Starting ITEM-Manipulation! Please enter your name.");
        String name = scanner.nextLine();

        System.out.println("Welcome " +name  +" to Item-Manipulation 1.0. Please enter a desire choice  of command");
          startPrompt();

    }
    private  static void startPrompt(){
//        inputString();
        boolean begin = true;

        System.out.println("Please enter a command: ");
        Scanner sc = new Scanner(System.in);
        while(begin){

            System.out.println("add || copy || delete || undo || quit " );
            String input = sc.nextLine();

                if (input.equalsIgnoreCase("add")) {
                    add(item);
                    item.peek();
                }
            while(!item.empty()) {
                if (input.equalsIgnoreCase("copy")) {
                    item.peek();
                    System.out.println("Adding the last item in the stack again");
                    copy(item);
                } else if (input.equalsIgnoreCase("delete")) {
                    delete(item);
                } else if (input.equalsIgnoreCase("undo")) {
                    undo(item);
                }
            }
               if  (input.equalsIgnoreCase("quit")) {
                  quitProgram();
              }
                else {
                startPrompt();

                  }

        }

    }
    public static void copy(Stack<String> st){
        System.out.println(st);
        String last=st.peek();
        st.push(last);
        System.out.println("Item has been copied.");
        System.out.println(item);
        startPrompt();
    }
    public static void delete(Stack<String> st) {
        System.out.println("Last item " +lastItem(st) +" deleted." );
        int sizeStack=st.size();
        if  (sizeStack<=1){
            System.out.println("Stack is empty user other method");
            startPrompt();
        }
        else
            st.pop();
            check=true;

        System.out.println(item);
        startPrompt();
    }
    public static void undo(Stack<String> st){
        if (check==true) {
            st.add(lastItem(st));

            System.out.println("Last action has been undone.");
            System.out.println(item);
        }
        else {
            System.out.println("Action denied !");
            startPrompt();
        }

        check=false;
    }
    public static void quitProgram() {
        System.out.println("Goodbye");
        System.exit(0);
    }
    public static String lastItem(Stack<String> st){
        String last=st.peek();
        return last;
    }
}

