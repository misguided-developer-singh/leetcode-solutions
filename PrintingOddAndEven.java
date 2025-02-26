import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class PrintingOddAndEven {

    public static void main(String[] args) {
        final int totalCount = 10;

        // Create semaphores: one for odd and one for even
        Semaphore oddSemaphore = new Semaphore(1);  // Odd starts first
        Semaphore evenSemaphore = new Semaphore(0); // Even waits for odd to finish

        // CompletableFuture for printing odd numbers
        CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> {
            int oddNumber = 1;
            while(oddNumber <= totalCount) {
                try {
                    oddSemaphore.acquire(); // Acquire the odd semaphore before printing

                    // Print the odd number with the thread name
                    System.out.println(Thread.currentThread().getName() + "-ODD-" + oddNumber);
                    oddNumber += 2;

                    // Release the even semaphore to allow even task to run
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // CompletableFuture for printing even numbers
        CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> {
            int evenNumber = 2;
            while(evenNumber <= totalCount) {
                try {
                    evenSemaphore.acquire(); // Acquire the even semaphore before printing
                    System.out.println(Thread.currentThread().getName() + "-EVEN-" + evenNumber);
                    evenNumber += 2;
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Wait for both tasks to complete
        CompletableFuture.allOf(oddTask, evenTask).join();
    }
}
