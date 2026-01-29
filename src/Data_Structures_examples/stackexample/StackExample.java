package Data_Structures_examples.stackexample;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        System.out.println("********** BASIC STACK OPERATIONS ************");
        System.out.println("************ PUSHING ELEMENTS ONTO A STACK ************");
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println("Current Stack: " + myStack);
        System.out.println("The size of my stack is: " + myStack.size());
        myStack.push(40);
        myStack.pop();
        System.out.println("Current Stack: " + myStack);
        System.out.println("POPPED: " + myStack.pop());
        myStack.push(50);
        myStack.push(60);
        System.out.println("PEEK ELEMENT: " + myStack.peek());
        System.out.println("Current STACK AFTER PEEK is: " + myStack);
        myStack.push(70);
        System.out.println(" Is My Stack Empty:  " + myStack.isEmpty());
        myStack.push(80);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(" Is My Stack Empty:  " + myStack.isEmpty());
        myStack.pop();
        System.out.println(" Is My Stack Empty:  " + myStack.isEmpty());
        myStack.push(90);
        myStack.push(100);
        System.out.println("THE Final stack in this stack is: " + myStack);
        // Current Stack: [10,20,30]
        // The size of my stack is: 3
        // Current Stack: [10,20,30]
        // POPPED: [10,20]
        //[10,20,50,60]
        // PEEK ELEMENT: 60
        // CURRENT STACK AFTER PEEK is: [10,20,50,60]
        //[10,20,50,60.70]
        // IS MY STACK EMPTY: False
        //[10,20,50,60,70,80]
        // 80 remove
        // 70 remove
        // 60 remove
        // 50 remove
        // 20 remove
        // IS MY STACK EMPTY: FALSE
        // 10 removed
        // IS MY STACK EMPTY: TRUE
        // [90,100]
        // The final stack in this stack is: [90,100]
    }
}
