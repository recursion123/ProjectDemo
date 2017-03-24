import org.junit.Test;

/**
 * Created by zhang on 2017/3/20.
 */
public class test3 {
    public static int i = 0;

    public synchronized static int getI() throws InterruptedException {
       if(i<100){
           Thread.sleep(10);
           i++;
       }
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 10; n++) {
            for (int m = 0; m < 1000; m++) {
                new Thread(() -> {
                    try {
                        getI();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            Thread.sleep(10000);
            System.out.println(i);
            i=0;
        }
    }

}
