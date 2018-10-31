package QuanLyOTo;

public class Car implements Comparable {
    private String id;
    private String name;
    private float weight;
    private int manufactureYear;

    public Car() {
        this.id = "";
        this.name = "";
        this.weight = 0.0f;
        this.manufactureYear = 1970;
    }

    public Car(String id, String name, float weight, int manufactureYear) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.manufactureYear = manufactureYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Override
    public String toString() {
        return String.format("%s. %s %.2f %d", id, name, weight, manufactureYear);
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.manufactureYear, ((Car) o).manufactureYear);

    }
}
