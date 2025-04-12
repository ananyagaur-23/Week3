public class ConcatenateStrings {
    public static String concatenate(String[] words) {
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Java", "is", "fun", "and", "powerful"};
        String result = concatenate(input);
        System.out.println("Concatenated String: " + result);
    }
}
