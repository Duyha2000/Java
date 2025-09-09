package Review.Example1;

public class Dog extends Animal<String> {
    public void dogBark(String s) {
        System.out.println(s);
    }

    @Override
    public void bark(String s) {
        System.out.println(s);
    }
}
