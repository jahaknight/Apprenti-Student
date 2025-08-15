import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private int year;


    public Car (String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String displayInfo(){
        return "Make" + brand + "Model:" + model + "Year:" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }
}
