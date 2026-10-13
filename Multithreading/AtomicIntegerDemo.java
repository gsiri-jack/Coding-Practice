package org.PracticeCoding.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    static void main() throws InterruptedException {
        CounterContainerA containerA = new CounterContainerA();
        Thread threadA = new Thread(containerA::IncrementCounter);
        Thread threadB = new Thread(containerA::IncrementCounter);
        Thread threadC = new Thread(containerA::IncrementCounter);

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadC.join();
        threadB.join();

        System.out.println(CounterContainerA.count);

    }

}

class CounterContainerA{
    static AtomicInteger count = new AtomicInteger(0);
    public void IncrementCounter(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }
}
