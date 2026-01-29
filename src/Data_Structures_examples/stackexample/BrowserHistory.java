package Data_Structures_examples.stackexample;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homepage;
        System.out.println("The browser opened home page: " + homepage);
    }
    public void visit(String url){
        backStack.push(currentPage);
        forwardStack.clear();
        currentPage = url;
        System.out.println("Visited Url: " + url);
    }

    public String back(){
        if (backStack.isEmpty())
        {
            System.out.println("Cannot go back, already a first page:" );
            return currentPage;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Went back to: " + currentPage);
        return currentPage;
    }
    public String forward()
    {
        if(forwardStack.isEmpty()){
            System.out.println("Cannot go forward no forward history");
            return currentPage;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("When forward to " + currentPage);
        return currentPage;
    }
    public String getCurrentPage(){
        return currentPage;
    }
    public void printHistory(){
        System.out.println("************** BROWSER HISTORY ***************");
        System.out.println("Back Stack (Oldest to Newest): " + backStack);
        System.out.println("Current Page: " + currentPage);
        System.out.println("Forward Stack (Newest to Oldest): " + forwardStack);
        // google
        // facebook
        // instagram
        // current page: twitter.com
        //[google, facebook, instagram]
        // twitter

    }
}
