package arg.dao;

public class Pause {

    public static void PauseAff(int val) throws InterruptedException {
        try {
            Thread.sleep(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
