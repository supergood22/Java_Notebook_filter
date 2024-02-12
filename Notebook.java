package Lesson6.ex;

public class Notebook {
    String model;
    Integer ram;
    Integer ssd;
    String os;
    String color;

    @Override
    public String toString() {
        return "model: " + model + ", ram: " + ram + ", ssd: " + ssd + ", os: " + os + ", color: " + color;
    }
}
