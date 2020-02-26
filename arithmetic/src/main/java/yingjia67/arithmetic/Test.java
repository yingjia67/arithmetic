package yingjia67.arithmetic;

public class Test {

    static class Ob{

    }

    public static void main(String[] args) {
        Test test = new Test();
        Integer a = 5;
        test.changeValue(a);
        System.out.println(a);
//        Ob ob = null;
//        test.changeValue(ob);
//        System.out.println(ob);


    }
    public void changeValue(Integer a){
        a = 4;
    }
    public void changeValue(Ob a){
        a = new Ob();
    }
}
