public abstract class DocumentFactory {
    public abstract Document createDocument();

    public void editDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}