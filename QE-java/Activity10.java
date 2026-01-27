package com.example;
import java.util.HashSet;
public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Mango");
        hs.add("Orange");
        hs.add("Grapes");
        hs.add("Pineapple");
        System.out.println("Size of HashSet: " + hs.size());
        hs.remove("Mango");
        boolean removed = hs.remove("Cherry");
        System.out.println("Is cherry removed? " + removed);
        System.out.println("Does Hasheset contain 'Apple'? " + hs.contains("Apple"));
        System.out.println("Does Hasheset contain 'Mango'? " + hs.contains("Mango"));
        System.out.println("Updated HashSet:");
        System.out.println(hs);
    }

}
