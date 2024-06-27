import java.util.HashMap;

// 509. Fibonacci Number

public class FibonacciNumber {


    HashMap<Integer, Integer> fibbMap = new HashMap<>();

    public int fib(int N) {
        fibbMap.put(0, 0);
        fibbMap.put(1, 1);

        if (!fibbMap.containsKey(N)) {
            return calculateFib(N - 1) + calculateFib(N - 2);
        }

        return fibbMap.get(N);
    }

    private int calculateFib(int N) {

        if (!fibbMap.containsKey(N)) {
             fibbMap.put(N, calculateFib(N - 1) + calculateFib(N - 2));
        }

        return fibbMap.get(N);
    }
}
