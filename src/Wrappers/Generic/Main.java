package Wrappers.Generic;

class Box<T> {
    T value; // T is a placeholder for any data type

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Box to hold a String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Barry Allen how are you doing professor Clifford Devoe");
        System.out.println("Value: " + stringBox.get());

        // Create a Box to hold an Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(50);
        System.out.println("Value: " + intBox.get());
    }
}


