public class SpreadsheetDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document");
    }

    @Override
    public void save() {
        System.out.println("Saving Spreadsheet Document");
    }

    @Override
    public void close() {
        System.out.println("Closing Spreadsheet Document");
    }
}