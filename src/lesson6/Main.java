package lesson6;

import java.io.*;
import java.util.Scanner;

public class Main {

    static void method() throws IOException {
        System.out.println("Hello!");
        throw new IOException("Something bad");
    }

    public static void main(String[] args) {
        //stringExample();
        //builderExample();
        //exceptionExample();
        InputStream in;
        OutputStream out;
        try {
//            FileOutputStream fos = new FileOutputStream("test", true);
//            byte[] b = {72, 'e', 'l', 'l', 'o'};
//            fos.write("Hello".getBytes());
//            fos.flush();
//            fos.close();
            PrintStream ps = new PrintStream(new FileOutputStream("test", true));
            ps.println("Hello world!");
            ps.close();

//            FileInputStream fis = new FileInputStream("test");
//            int b;
//            while ((b = fis.read()) != -1) {
//                System.out.print((char) b);
//            }
            Scanner sc = new Scanner(new FileInputStream("test"));
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exceptionExample() {
        try {
            method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void builderExample() {
        long startTime = System.nanoTime();
        String s = "Example";
        for (int i = 0; i < 100_000; i++) {
            s += i;
        }
        float deltaTime = System.nanoTime() - startTime;
        System.out.println("delta time: " + (deltaTime * 0.000000001f));

        startTime = System.nanoTime();
        StringBuilder s1 = new StringBuilder("Example");
        for (int i = 0; i < 100_000; i++) {
            s1.append(i);
        }
        deltaTime = System.nanoTime() - startTime;
        System.out.println("delta time: " + (deltaTime * 0.000000001f));

        System.out.println(s.equals(s1.toString()));
    }

    private static void stringExample() {
        Scanner sc = new Scanner(System.in);
        String s0 = "hello";
        String s1 = "hello";
        String s2 = new String("he");
        String s3 = s2 + "llo";
        String s4 = sc.next();

        System.out.println(s0.equals(s1));
        System.out.println(s0.equals(s3));
        System.out.println(s0.equals(s4));
    }
}
