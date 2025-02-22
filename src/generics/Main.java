package generics;



public class Main {
    public static void main(String[] args) {
        Box<String> stringBox=new Box<>();
        stringBox.setValue("Hello, Generics!");
        System.out.println(stringBox.getValue());

        Box<Integer> intBox = new Box<>();
        intBox.setValue(123);
        System.out.println(intBox.getValue());

    }
}
