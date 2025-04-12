public class CompareBuilderBuffer {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String word = "hello";

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(word);
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(word);
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("StringBuffer time (ns): " + bufferTime);
        System.out.println("StringBuilder time (ns): " + builderTime);
    }
}
