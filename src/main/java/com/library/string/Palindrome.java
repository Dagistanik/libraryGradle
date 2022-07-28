package com.library.string;

public class Palindrome {
    public static String palindrome(String word){
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)){
                return "Not a palindrome";
            }
        }
        return "Palindrome";
    }
    public static void main(String[] args) {
        System.out.println(palindrome("шалаш"));
    }
}
