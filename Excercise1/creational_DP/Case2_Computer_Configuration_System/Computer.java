public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String operatingSystem;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
               "CPU: " + cpu + "\n" +
               "RAM: " + ram + "\n" +
               "Storage: " + storage + "\n" +
               "GPU: " + gpu + "\n" +
               "Operating System: " + operatingSystem;
    }
}