public class TextDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}
