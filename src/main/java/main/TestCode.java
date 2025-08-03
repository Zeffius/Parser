package main;

import java.util.Arrays;

public class TestCode {

    public static void test ()
    {
        String line = "Storm Spirit | 2.12% | 50.63%";
        String[] parts = line.trim().split("");

        for (String g: parts)
        {
            System.out.println(g);
        }
        System.out.println(Arrays.toString(parts));
    }
}
