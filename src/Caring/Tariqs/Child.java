package Caring.Tariqs;

public class Child extends Parent{
    @Override
    public void Speak() {
        System.out.println("child speaks from overriden method");
    }
    public void Play(){
        System.out.println("Child is playing");
    }
}
