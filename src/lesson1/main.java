package lesson1;

public class main {

    //задание 1
    public static void main() {
    }
    //задание 2
    byte a = 127;
    short b = 32767;
    int c = 2147483647;
    long d = 9223372036854775807L;
    float e =  12.0f;
    double f = 123.123;
    char g = 'I';
    boolean h = true;

    public static void main(String[] args) {
        System.out.println("Уравнение a * (b + (c / d)) = " + three(5,7,9,2));
        System.out.println(four(23,11));
        five(-14);
        six(176);
        seven("Алексей");
        eight(2020);


    }
    public static int three(int a, int b, int c, int d){
        System.out.println("Задание 3");
        return a * (b + (c / d));
    }

    public static boolean four(int a, int b){
        System.out.println("Задание 4");
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void five(int a){
        System.out.println("Задание 5");
        if (a >= 0) System.out.println(a + " положительное");
        else System.out.println(a + " отрицательное");
    }

    public static void six(int a){
        System.out.println("Задание 6");
        if (a < 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void seven(String name){
        System.out.println("Задание 7");
        System.out.println("Привет, " + name);
    }

    public static void eight(int year) {
        System.out.println("Задание 8");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println(year + " год не високосный.");
        } else {
            System.out.println(year + " год високосный.");
        }
    }


}

