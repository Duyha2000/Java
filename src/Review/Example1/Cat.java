package Review.Example1;

public class Cat extends Animal<String> {
    public void catBark(String s) {
        System.out.println(s);
    }

    @Override
    public void bark(String s) {
        System.out.println(s);
    }
}
