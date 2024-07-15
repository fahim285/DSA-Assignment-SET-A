import java.util.*;

public class CarImportationSystem {
    private List<Car> carList = new ArrayList<>();
    private Queue<Car> importQueue = new LinkedList<>();
    private Set<String> uniqueModels = new HashSet<>();
    private Map<String, String> modelToImporter = new HashMap<>();
    private Stack<String> importTransactions = new Stack<>();

    public void addCar(Car car) {
        carList.add(car);
        importQueue.add(car);
        uniqueModels.add(car.getModel());
        modelToImporter.put(car.getModel(), car.getImporter());
        importTransactions.push("Imported: " + car);
    }

    public Car processNextImport() {
        Car car = importQueue.poll();
        if (car != null) {
            importTransactions.push("Processed import: " + car);
        }
        return car;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Queue<Car> getImportQueue() {
        return importQueue;
    }

    public Set<String> getUniqueModels() {
        return uniqueModels;
    }

    public Map<String, String> getModelToImporter() {
        return modelToImporter;
    }

    public Stack<String> getImportTransactions() {
        return importTransactions;
    }

    public static void main(String[] args) {
        CarImportationSystem system = new CarImportationSystem();
        
        Car car1 = new Car("Model S", "Tesla", 2022, "Importer A");
        Car car2 = new Car("Civic", "Honda", 2021, "Importer B");
        Car car3 = new Car("Mustang", "Ford", 2022, "Importer A");

        system.addCar(car1);
        system.addCar(car2);
        system.addCar(car3);

        System.out.println("Car List:");
        for (Car car : system.getCarList()) {
            System.out.println(car);
        }

        System.out.println("\nProcessing Imports:");
        Car processedCar;
        while ((processedCar = system.processNextImport()) != null) {
            System.out.println("Processed: " + processedCar);
        }

        System.out.println("\nUnique Models:");
        for (String model : system.getUniqueModels()) {
            System.out.println(model);
        }

        System.out.println("\nModel to Importer Map:");
        for (Map.Entry<String, String> entry : system.getModelToImporter().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nImport Transactions:");
        while (!system.getImportTransactions().isEmpty()) {
            System.out.println(system.getImportTransactions().pop());
        }
    }
}
