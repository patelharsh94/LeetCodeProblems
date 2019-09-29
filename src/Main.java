import DataStructuresAndAlgoImplementations.BinarySearch;

public class Main {

    public static void main(String [] args) {

        int [] data = new int [] {-1, 3, 5, 9, 10, 29, 33};

        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.binarySearchRecursive(29, data));
    }
}
