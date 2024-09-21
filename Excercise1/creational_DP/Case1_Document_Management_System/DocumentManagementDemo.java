public class DocumentManagementDemo {
    public static void main(String[] args) {
        DocumentFactory textFactory = new TextDocumentFactory();
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        DocumentFactory spreadsheetFactory = new SpreadsheetDocumentFactory();

        System.out.println("Editing a text document:");
        textFactory.editDocument();

        System.out.println("\nEditing a PDF document:");
        pdfFactory.editDocument();

        System.out.println("\nEditing a spreadsheet document:");
        spreadsheetFactory.editDocument();
    }
}