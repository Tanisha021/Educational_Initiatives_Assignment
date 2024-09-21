public interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setRam(String ram);
    ComputerBuilder setStorage(String storage);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setOperatingSystem(String operatingSystem);
    Computer build();
}
