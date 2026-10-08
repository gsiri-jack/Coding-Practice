package org.PracticeCoding.Multithreading;

public class RaceConditionDemo {

/*
        The RaceCondition is occurred when two threads to use a single resource,
        when doing so the thread may access the value which is not complete updated.
        So, there will inconsistency .
 */
    public static SharedContainer container = new SharedContainer();

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new incrementValueOne(container));
        Thread threadTwo = new Thread(new incrementValueTwo(container));

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println(container.counter);
    }


}

class incrementValueOne implements Runnable{

  private final SharedContainer container;

    public incrementValueOne(SharedContainer sharedContainer){
        this.container=sharedContainer;
    }

    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            container.counter++;
        }
    }
}

class incrementValueTwo implements Runnable{

   private final SharedContainer container;

    public incrementValueTwo(SharedContainer sharedContainer){
        this.container=sharedContainer;
    }

    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            container.counter++;
        }
    }
}

class SharedContainer {
    public int counter;
}
