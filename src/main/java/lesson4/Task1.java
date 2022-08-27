package lesson4;

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


    public void chainOfThreadsToStart() {
        new Thread(() -> printLetter('C')).start();
        new Thread(() -> printLetter('B')).start();
        new Thread(() -> printLetter('A')).start();
    }

    public static void main(String[] args) {
        new Task1().chainOfThreadsToStart();
    }
}
