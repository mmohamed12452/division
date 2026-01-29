package Data_Structures_examples.stackexample;

public class BrowserExample {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("google.com");
        browser.visit("facebook.com");
        browser.visit("instagram.com");
        browser.visit("twitter.com");
        browser.printHistory();
        System.out.println("NAVIGATION");
        browser.back();
        browser.back();
        browser.forward();
        browser.visit("soundcloud.com");
        browser.printHistory();
        browser.visit("apple.com");
        browser.visit("mercedes.com");
        browser.visit("range-rover.com");
        browser.visit("starz.com");
        browser.back();
    }
}
