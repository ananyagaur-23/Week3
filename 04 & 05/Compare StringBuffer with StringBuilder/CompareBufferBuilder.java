public class CompareBufferBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;

        long startTime1 = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endTime1 = System.nanoTime();
        long bufferTime = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long endTime2 = System.nanoTime();
        long builderTime = endTime2 - startTime2;

        System.out.println("StringBuffer time (ns): " + bufferTime);
        System.out.println("StringBuilder time (ns): " + builderTime);
    }
}
