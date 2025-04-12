public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The sky is blue.",
                "She sells seashells by the seashore.",
                "Java is a versatile language.",
                "Enjoy the little things."
        };
        String word = "Java";
        System.out.println(findSentenceWithWord(sentences, word));
    }
}
