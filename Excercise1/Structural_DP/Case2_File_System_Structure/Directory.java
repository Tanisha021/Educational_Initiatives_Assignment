import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children;

    public Directory(String name) {
        super(name);
        children = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        children.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name + " (" + getSize() + " bytes)");
        for (FileSystemComponent component : children) {
            component.display(indent + "  ");
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}