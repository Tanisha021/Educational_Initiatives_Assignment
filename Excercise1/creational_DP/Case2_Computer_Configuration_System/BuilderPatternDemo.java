public class BuilderPatternDemo {
    public static void main(String[] args) {
        ComputerBuilder builder = new DesktopComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        Computer gamingPC = director.constructGamingPC();
        System.out.println("Gaming PC Configuration:");
        System.out.println(gamingPC);

        System.out.println("\n------------------------\n");

        Computer officePC = director.constructOfficePC();
        System.out.println("Office PC Configuration:");
        System.out.println(officePC);

        System.out.println("\n------------------------\n");

        Computer customPC = builder.setCpu("AMD Ryzen 7")
                                   .setRam("64GB DDR4")
                                   .setStorage("2TB NVMe SSD")
                                   .setGpu("AMD Radeon RX 6800 XT")
                                   .setOperatingSystem("Ubuntu 20.04")
                                   .build();
        System.out.println("Custom PC Configuration:");
        System.out.println(customPC);
    }
}