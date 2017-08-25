package com.kurotkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static int num = 9;
    public static double torque = 12.1;
    public static String serno = "12321394463";
    public static String name = "Zatycshka123";

    public static void main(String[] args) {
        if (args.length != 0) {
            num = Integer.parseInt(args[0]);
            torque = Double.parseDouble(args[1]);
            serno = args[2];
            name = args[3];
        }
        SpringApplication.run(Main.class, args);
    }
}
