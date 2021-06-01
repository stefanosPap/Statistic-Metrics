package CodingEvaluationTest;

import org.apache.commons.math3.stat.descriptive.rank.Min;

public class Simple {
    public static int method(){
        int a = 1;
        a+=1;
        return a;
    }
    public static double getMinimum(double[] array){
        Min m = new Min();
        return m.evaluate(array);
    }
    public static void main(String[] args){

        int a = method();
        System.out.println(a);
    }
}
