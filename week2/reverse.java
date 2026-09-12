import java.util.Scanner;

class Main {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reverse = new StringBuilder(words[i]);
            reverse.reverse();

            result.append(reverse);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        String output = reverseEachWord(sentence);

        System.out.println(output);

        sc.close();
    }
}