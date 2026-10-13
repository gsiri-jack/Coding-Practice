package org.PracticeCoding.Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {


    static void main() throws InterruptedException {
        CounterContainer container = new CounterContainer();

        Thread threadA = new Thread(new ThreadA(container));
        Thread threadB = new Thread(container::incrementCounter);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println(CounterContainer.counter);

    }

}

class CounterContainer{
    static int counter = 0;
    private final static ReentrantLock lock = new ReentrantLock();
    //Here we are declaring the reentrant lock as static because every instance of it must have the same class so that it will like a common room with lock as per our analogy


    public void incrementCounter(){
        System.out.println("Entering into increment function - ");
        try{
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                try{
                    for(int i=0; i<10000; i++){
                        counter++;
                    }
                }catch (Exception e){
                    System.out.println("error happened");
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("Error in accessing the lock");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
// Threads
class ThreadA implements Runnable{

    CounterContainer container;
    public ThreadA(CounterContainer cont){
        this.container=cont;
    }

    @Override
    public void run(){
        container.incrementCounter();
    }
}


