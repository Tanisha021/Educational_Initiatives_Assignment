public class FileSystemDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory home = new Directory("home");
        Directory user = new Directory("user");
        File file1 = new File("document.txt", 100);
        File file2 = new File("image.jpg", 2000);

        user.addComponent(file1);
        user.addComponent(file2);
        home.addComponent(user);

        Directory etc = new Directory("etc");
        File file3 = new File("config.ini", 50);
        etc.addComponent(file3);

        root.addComponent(home);
        root.addComponent(etc);

        System.out.println("File System Structure:");
        root.display("");

        System.out.println("\nTotal size of root: " + root.getSize() + " bytes");
    }
}