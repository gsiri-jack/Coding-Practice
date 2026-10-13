package org.PracticeCoding.Multithreading;

public class SynchronizedDemo {

    static void main() throws InterruptedException {

        SynchronizedContainer container = new SynchronizedContainer();


        // Thread Handlers
        Thread one = new Thread(new ThreadOne(container));
        Thread two = new Thread(new ThreadTwo(container));


        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(SynchronizedContainer.counter);

    }

}
class SynchronizedContainer {
    protected static int counter;


    public synchronized void increaseCounter(){
      counter=counter+1;
    }

}
class ThreadOne implements Runnable{

    SynchronizedContainer container ;

    public ThreadOne (SynchronizedContainer container){
        this.container=container;
    }


    @Override
    public void run(){
        for (int i=0; i<10000; i++){
            container.increaseCounter();
        }
    }
}

class ThreadTwo implements Runnable{

    SynchronizedContainer container ;

    public ThreadTwo (SynchronizedContainer container){
        this.container=container;
    }



    @Override
    public void run(){
        for (int i=0; i<10000; i++){
            container.increaseCounter();
        }
    }
}
