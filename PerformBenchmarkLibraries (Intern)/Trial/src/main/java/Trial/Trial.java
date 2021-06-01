package Trial;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;

import java.util.Arrays;

public class Trial {
    public static int method(){
        int a = 1;
        a+=1;
        return a;
    }
    public static int method2(){
        int a = 1;
        a+=1;
        return a;
    }
    public static double getMinimum(double[] array){
        Min m = new Min();
        double r = 0.0;
        r = m.evaluate(array);
        r += Arrays.stream(array).min().orElse(Double.NEGATIVE_INFINITY);


        return r;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(40000);
        double b = getMinimum(new double[]{1.2, 3.4});

        int a = method();
        int c = method2();

        System.out.println(a);
        System.out.println(b);

    }
}
