public class SpreadsheetDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new SpreadsheetDocument();
    }
}