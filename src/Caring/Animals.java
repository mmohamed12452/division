package Caring;

abstract class Animals {
    public abstract void animalsNames();
    public abstract void animalsSound();

    public void Henry() {
        String name = "johhny";
        int age = 16;
        System.out.println(name);
        System.out.println(age);
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.Henry();
        runner.animalsNames();
        runner.animalsSound();
    }
}
