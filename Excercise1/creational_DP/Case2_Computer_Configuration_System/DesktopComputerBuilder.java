public class DesktopComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public DesktopComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        computer.setGpu(gpu);
        return this;
    }

    @Override
    public ComputerBuilder setOperatingSystem(String operatingSystem) {
        computer.setOperatingSystem(operatingSystem);
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}