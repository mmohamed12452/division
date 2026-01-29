package Data_Structures_examples.queueexample;

public class PrintJob {
    private String documentName;
    private int pages;
    private String user;


    public PrintJob(String documentName, int pages, String user) {
        this.documentName = documentName;
        this.pages = pages;
        this.user = user;
    }

    public String getDocumentName() {
        return documentName;
    }

    public int getPages() {
        return pages;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return String.format("%s  (%d pages) - %s", documentName,pages,user);
    }
}
