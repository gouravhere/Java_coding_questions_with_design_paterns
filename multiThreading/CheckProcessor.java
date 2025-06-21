package multiThreading;

public class CheckProcessor implements Runnable {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
/* <<<<<<<<<<  564fa779-3f94-466b-a7d0-262a6775e1d2  >>>>>>>>>>> */
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
/**
 * The main method serves as the entry point for the application.
 * It creates a new thread using the CheckProcessor class, which
 * implements the Runnable interface, and starts the thread.
 *
 * The commented line demonstrates how to interrupt the thread
 * if needed.
 *
 * @param args command line arguments
 */

/* <<<<<<<<<<  08aecd74-1f4c-4feb-a768-988745f265fe  >>>>>>>>>>> */
public static void main(String[] args) {
    Thread thread = new Thread(new CheckProcessor());
    thread.start();
   //For interrupting--- thread.interrupt();
}
}
