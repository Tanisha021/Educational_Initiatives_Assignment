public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructGamingPC() {
        return builder.setCpu("Intel Core i9")
                      .setRam("32GB DDR4")
                      .setStorage("1TB NVMe SSD")
                      .setGpu("NVIDIA RTX 3080")
                      .setOperatingSystem("Windows 10 Pro")
                      .build();
    }

    public Computer constructOfficePC() {
        return builder.setCpu("Intel Core i5")
                      .setRam("16GB DDR4")
                      .setStorage("512GB SSD")
                      .setGpu("Integrated Graphics")
                      .setOperatingSystem("Windows 10 Home")
                      .build();
    }
}