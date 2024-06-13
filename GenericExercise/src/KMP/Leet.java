package KMP;

import java.util.ArrayList;

public class Leet {

    public static String toLeet(String normal){
        normal = normal.replaceAll("elite", "1337");
        normal = normal.replaceAll("cool", "k3wl");
        normal = normal.replaceAll("!", "!!!11");
        normal = normal.replaceAll("ck", "xx");
        normal = normal.replaceAll("ers", "0rz");
        normal = normal.replaceAll("er", "0rz");
        normal = normal.replaceAll("en", "n");
        normal = normal.replaceAll("e", "3");
        normal = normal.replaceAll("t", "7");
        normal = normal.replaceAll("o", "0");
        normal = normal.replaceAll("a", "@");
        return normal;
    }
    public static String[] allToLeet(String[] normals){
        String[] a = new String[normals.length];
        int i = 0;
        while(normals[i] != null){
            a[i] = normals[i];
            i++;
        }

        for (i = 0; i < normals.length; i++) {
            if(a[i] == null) break;
            a[i] = toLeet(normals[i]);
        }
        i = 0;
        while(a[i] != null){
            i++;
        }
        String[] b = new String[i];
        while(a[i] != null){

        }
        return a;
    }
}
