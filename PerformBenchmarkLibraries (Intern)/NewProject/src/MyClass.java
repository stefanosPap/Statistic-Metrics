public class MyClass {

    public MyClass()
    {
        int a = 1;
    }
    public static void meth(){
        int a = 2;
        //Thread.sleep(40000);
        for (int i = 0; i < Double.POSITIVE_INFINITY; i++)
        {
            a+=1;
            System.out.println(a);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new MyClass();
        meth();
    }
}
