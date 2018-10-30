package QuanLyOTo;

import Searching.BinarySearchST;
import Sorting.Heap;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Car[] cars = readData(Paths.get("src/data.txt").toAbsolutePath().toString());

        if (cars == null) {
            return;
        }

        //Before sort
        show(cars, "src/output_before_sort.txt");
        //Sort
        Heap.sort(cars);
        //After sort
        show(cars, "src/output_after_sort.txt");

        //Searching
        BinarySearchST<String, Car> binarySearchST = new BinarySearchST<>();
        for (Car car : cars) {
            binarySearchST.put(car.getName(), car);
        }

        for (String key : binarySearchST.keys()) {
            System.out.println(key + " => " + binarySearchST.get(key));
        }
    }

    public static void show(Comparable[] array, String outputPath) {

        if (outputPath != null) {
            try {
                PrintStream console = System.out;
                System.setOut(new PrintStream(new File(outputPath)));
                printArray(array);
                System.setOut(console);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return;
        }

        printArray(array);
    }

    private static void printArray(Comparable[] array) {
        for (Comparable anArray : array) {
            System.out.println(anArray);
        }
    }

    private static Car[] readData(String path) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            List<Car> listCar = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("\\|");
                listCar.add(new Car(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        Float.parseFloat(arr[2]),
                        Integer.parseInt(arr[3])
                ));
            }

            bufferedReader.close();

            return listCar.toArray(new Car[0]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
