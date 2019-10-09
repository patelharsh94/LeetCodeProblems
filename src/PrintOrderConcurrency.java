import java.util.concurrent.atomic.AtomicInteger;

// 1114. Print in Order
public class PrintOrderConcurrency {

    AtomicInteger functionCounter = new AtomicInteger(0);

    public  PrintOrderConcurrency() {}

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        functionCounter.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (functionCounter.get() != 1) {}
        printSecond.run();
        functionCounter.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (functionCounter.get() != 2) {}
        printThird.run();
    }
}
