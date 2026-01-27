package com.example;

//public class Book {
    abstract class Book{
        String title;
        abstract void setTitle(String s);
        String getTitle(){
            return title;
        }
    }
    class MyBook extends Book{
        public void setTitle(String s){
            title = s;
        }
        public static void main(String[] args){
            MyBook newNovel = new MyBook();
            String title = "Java Programming";
            newNovel.setTitle(title);
            System.out.println("The title is: " + newNovel.getTitle());
        }
    }

