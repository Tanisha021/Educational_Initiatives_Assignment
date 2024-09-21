public class File extends FileSystemComponent {
    private long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " bytes)");
    }

    @Override
    public long getSize() {
        return size;
    }
}
