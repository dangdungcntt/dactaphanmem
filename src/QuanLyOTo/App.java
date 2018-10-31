package QuanLyOTo;

import Searching.BinarySearchST;
import Searching.SeparateChainingHashST;
import Sorting.Heap;
import Sorting.MaxPQ;
import Sorting.MinPQ;
import stdlib.StdIn;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) throws FileNotFoundException {


        //Searching
        SeparateChainingHashST<String, Car> st = new SeparateChainingHashST<>();
        System.setIn(new FileInputStream(new File("src/data.txt")));

        while(!StdIn.isEmpty()) {
            String str = StdIn.readLine();
            String[] arr = str.split("\\|");
            st.put(arr[0], new Car(
                    arr[0],
                    arr[1],
                    Float.parseFloat(arr[2]),
                    Integer.parseInt(arr[3])
            ));
        }

        MinPQ<Car> queue = new MinPQ<>();

        for (String s : st.keys()) {
            queue.insert(st.get(s));
        }

        System.setOut(new PrintStream(new File("src/output.txt")));

        for (Car car : queue) {
            System.out.println(car);
        }
    }
}
