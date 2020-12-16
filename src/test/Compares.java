package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project hackerrank.
 * <p>
 * Created by Rhony  on 06/08/20.
 */
class Compares {
    public static void main(String args[]) {
        String[] cities = {"Bungalore", "Pune", "San Fran", "New York"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "New York"));
    }

    static class MySort implements Comparator<String> {

        @Override public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
