public class Car {
    private String model;
    private String manufacturer;
    private int year;
    private String importer;

    public Car(String model, String manufacturer, int year, String importer) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.importer = importer;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getImporter() {
        return importer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", importer='" + importer + '\'' +
                '}';
    }
}
