package org.PracticeCoding.Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sharedAccount = new BankAccount(100.0);

        Thread thread1 = new Thread(
                () -> sharedAccount.withdraw("Thread-1", 50.0),
                "Worker-1"
        );

        Thread thread2 = new Thread(
                () -> sharedAccount.withdraw("Thread-2", 30.0),
                "Worker-2"
        );

        thread1.start();

        Thread.sleep(100);

        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("\nFinal Operation Complete.");
    }
}

class BankAccount {
    private final ReentrantLock lock = new ReentrantLock();
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(String threadName, double amount) {
        System.out.println("[" + threadName + "] Attempting to acquire lock...");

        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("  ✓ [" + threadName + "] Lock acquired! Processing withdrawal...");

                    Thread.sleep(1000);

                    if (balance >= amount) {
                        balance -= amount;
                        System.out.println("  ✓ [" + threadName + "] Successfully withdrew $" + amount
                                + ". Remaining balance: $" + balance);
                    } else {
                        System.out.println("  ✗ [" + threadName + "] Insufficient funds.");
                    }
                } finally {
                    lock.unlock();
                    System.out.println("  🔒 [" + threadName + "] Lock released.");
                }
            } else {
                System.out.println("  ⚠️ [" + threadName + "] Could not acquire lock within 2 seconds. Request timed out!");
            }
        } catch (InterruptedException e) {
            System.out.println("[" + threadName + "] Thread was interrupted while waiting for lock.");
            Thread.currentThread().interrupt();
        }
    }
}