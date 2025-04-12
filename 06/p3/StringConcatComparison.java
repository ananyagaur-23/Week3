public class StringConcatComparison {
    public static void main(String[] args){
        int N = 1_000_000;
        String word = "a";

        long start = System.nanoTime();
        String str = "";
        for(int i =0; i<N; i++){
            str = word + str;
        }
        long end = System.nanoTime();
        System.out.printf("String Time: %.2f ms\n",(end-start)/1e6);

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(word);
        }
        end = System.nanoTime();
        System.out.printf("StringBuilder Time: %.2f ms\n",(end-start)/1e6);

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for(int i = 0; i<N; i++){
            sbuf.append(word);
        }
        end = System.nanoTime();
        System.out.printf("StringBuffer Time: %.2f ms\n",(end-start)/1e6);
    }
}
