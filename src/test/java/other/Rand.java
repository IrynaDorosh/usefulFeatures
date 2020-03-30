package other;

import org.testng.annotations.Test;

import java.util.Random;

public class Rand {

    @Test
    public void test1() {
        System.out.println(getRandomNumberInRange(1, 5));
    }

    public  static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
