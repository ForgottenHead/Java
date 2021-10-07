package cz.mendelu.pjj.xstast12.helloWorld;

public class HelloWorld {

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.printf("Hello %s\n", args[i]);
        }

    }
}
