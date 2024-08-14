package utils;

public class SplitInput {

    public static String splitAndReturnD(String inputText) {
        String[] words = inputText.split(" ");
        String letter = words[5].replace("\"", "");
        return letter.repeat(Integer.valueOf(words[1]));
    }

    public static void main(String[] args) {
        String input = "Write 20 times the letter \"d\"";
        String result = splitAndReturnD(input);
        System.out.println(result);
    }
    
}
