package Data_Structures_examples.stackexample;

import java.util.Stack;

public class Texteditor {
    private StringBuilder currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private Stack<String> bookmarkStack;

    public Texteditor() {
        currentText = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        bookmarkStack = new Stack<>();
        saveState("Initial empty document");
    }
    private void saveState(String action){
        String state = action + "||" + currentText.toString();
        undoStack.push(state);
        redoStack.clear();
        System.out.println("save state: " + action);
    }
    public void type(String text){
        saveState("Type: \"" + text + "\"");
        currentText.append(text);
    }
    public void delete(int numberCharacter){
     if (numberCharacter <= 0 || currentText.length() == 0) return;

     if(numberCharacter > currentText.length()){
         numberCharacter = currentText.length();
     }

     int start = currentText.length() - numberCharacter;
     String deleted = currentText.substring(start);
        saveState("Delete: \"" + deleted + "\"");
        currentText.delete(start,currentText.length());
        displayText();
    }

    public void insertAt(String text, int position){
        if (position < 0 || position > currentText.length()){
            System.out.println("invalid position");
            return;
        }
        saveState(  "Insert: \"" + text + "\" at position " + position);
        currentText.insert(position,text);
        displayText();
    }
    public void undo(){
        if (undoStack.size() <= 1){
            System.out.println("nothing to undo");
            return;
        }

        redoStack.push(undoStack.peek());
        undoStack.pop();
        String[] parts = undoStack.peek().split("\\|\\|", 2);
        currentText = new StringBuilder(parts.length > 1 ? parts[1] : "");

        System.out.println("↩️ Undo: " + parts[0]);
        displayText();
    }
    public void redo(){
        if (redoStack.isEmpty()){
            System.out.println("nothing to redo");
            return;
        }
        String state = redoStack.pop();
        undoStack.push(state);
        String[] parts = state.split("\\|\\|", 2);
        currentText = new StringBuilder(parts.length > 1 ? parts[1] : "");

        System.out.println("↪️ Redo: " + parts[0]);
        displayText();
    }
    public void bookmark(){
        bookmarkStack.push(currentText.toString());
        System.out.println("Bookmark saved. Total bookmarks: " + bookmarkStack.size());
    }
    public void restoreBookmark(){
        if (bookmarkStack.isEmpty()){
            System.out.println("No bookmarks are avaliable");
            return;
        }
        saveState("restore bookmark");
        currentText = new StringBuilder(bookmarkStack.pop());
        System.out.println("restored from bookmark");
        displayText();
    }
    public void showHistory(){
        System.out.println("EDITING HISTORY");
        Stack<String> temp = new Stack<>();
        temp.addAll(undoStack);
        Stack<String> displayOrder = new Stack<>();
        while (!temp.isEmpty()){
            displayOrder.push(temp.pop());
        }
        int step = 0;
        while (!displayOrder.isEmpty()) {
            String[] parts = displayOrder.pop().split("\\|\\|", 2);
            System.out.printf("%2d. %-30s: %s\n",
                    step++,
                    parts[0],
                    parts.length > 1 ?
                            (parts[1].length() > 20 ? parts[1].substring(0, 20) + "..." : parts[1])
                            : "");
        }
    }
    public void displayText(){
        System.out.println("\nCurrent text [" + currentText.length() + " chars]:");
        System.out.println("\"" + currentText + "\"");
        System.out.println("Undo available: " + (undoStack.size() - 1));
        System.out.println("Redo available: " + redoStack.size());
        System.out.println("Bookmarks: " + bookmarkStack.size());
        System.out.println();
    }
    public void findAndReplace(String find, String replace){
        int index = currentText.indexOf(find);
        if(index == -1){
            System.out.println("Text not found: " + find);
            return;
        }

        saveState("Replace: \"" + find + "\" with \"" + replace + "\"");
        String newText = currentText.toString().replace(find,replace);
        currentText = new StringBuilder(newText);

        int count = (currentText.length() - newText.length())  /  (find.length() - replace.length());
        System.out.println("Replaced " + count + " occurrence(s)");
        displayText();
    }
}

