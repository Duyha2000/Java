package B1.Exercices;

public class tut4 {
    public static void main(String[] args) {
        int hehe = 483274;
        int quan = hehe / 1000;
        int thuaQuan = hehe % 1000;
        int dong = thuaQuan / 100;
        int thuaDong = thuaQuan % 100;
        int hao = thuaDong / 10;
        int xu = thuaDong % 10;
        System.out.println(hehe + " xu converts into:");
        System.out.println(quan + " quan, " + dong + " dong, " + hao + " hao, " + xu + " xu");
    }
}
