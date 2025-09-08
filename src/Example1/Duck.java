package Example1;

public class Duck extends Animal<Integer> {
    //    https://code-with-me.global.jetbrains.com/NpMkWjT86TGLM6WU7Sf_7A#p=IU&fp=EEE9C5B665F7B80D0C0ACD73AFCC5EC7FD1B2982E2F5317DCECF772F249F1D44&newUi=true
    // https://docs.google.com/document/d/1QJ0HjcUUvCcFyZ8dSCwUWJCuCwMh1QS0sGw07fucP2I/edit?tab=t.0
    // attribute:
    // public
    public void duckBark(String s) {
        System.out.println(s);
    }

    @Override
    public void bark(Integer s) {
        System.out.println(s + "custom");
    }
}
