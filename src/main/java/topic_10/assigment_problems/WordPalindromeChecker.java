import java.util.Scanner;

public class WordPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        StringBuilder builder = new StringBuilder(word);
        String reversed = builder.reverse().toString();

        System.out.println(reversed + (word.equals(reversed)
                ? " - palindrome"
                : " - not a palindrome"));

        sc.close();
    }
}