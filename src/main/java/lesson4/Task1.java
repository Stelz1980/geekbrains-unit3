package lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    private volatile char currentLetter = 'A';
    private final Object monitor = new Object();
    private static final int NUMBER_TO_REPEAT = 5;

    private void printLetter(char letter) {
        synchronized (monitor) {
            for (int i = 1; i <= NUMBER_TO_REPEAT; i++) {
                try {
                    while (currentLetter != letter) {
                        monitor.wait();
                    }
                    System.out.print(letter);
                    setNextCurrentLetter();
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setNextCurrentLetter() {
        if (currentLetter == 'C') {
            currentLetter = 'A';
        } else {
            currentLetter++;
        }
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            service.execute(() -> task1.printLetter((char) ('A' + finalI)));
        }
        service.shutdown();
    }
}
