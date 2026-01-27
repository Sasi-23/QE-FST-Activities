package com;
import java.util.HashMap;
import java.util.Map;
public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Black");
        System.out.println("Colours Map:");
        System.out.println(colours);
        colours.remove(2);
        if (colours.containsValue("Green")){
            System.out.println("Green colour exist in the map");
        }else{
            System.out.println("Green colour does not exist in the map");


        }
        System.out.println("Size of the map: " + colours.size());

    }

}
