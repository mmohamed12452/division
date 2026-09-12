package Data_Structures_examples.stackexample;

public class AdvancedTextEditorExample {
    public static void main(String[] args) {
        System.out.println("ADVANCED TEXT EDITOR WITH MULTIPLE UNDO/REDO");

        Texteditor editor = new Texteditor();

        editor.type("Hello Mohamed");
        editor.bookmark();

        editor.type("Mohamed is my other name");
        editor.insertAt("Mohamed", 4);

        editor.showHistory();

        System.out.println("EDITING SESSION");
        editor.delete(7);
        editor.type("Stack Example");

        editor.findAndReplace("Mohamed", "Bryson");

        System.out.println("UNDO OPERATION");
        editor.undo();
        editor.undo();
        editor.undo();

        System.out.println("REDO OPERATION");
        editor.redo();
        editor.redo();

        System.out.println("BOOKMARK RESTORE");
        editor.restoreBookmark();

        editor.type("THIS DEMONSTRATES A STACK EXAMPLE");
        editor.type("UNDO/REDO METHOD USES LIFO PRINCIPLE");

        editor.showHistory();

        System.out.println("FINAL DOCUMENT");
        editor.displayText();

    }
}
