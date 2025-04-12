import java.io.*;

public class CompareReaders {
    public static void main(String[] args) {
        try {
            long startFileReader = System.nanoTime();
            FileReader fr = new FileReader("largefile.txt");
            BufferedReader br = new BufferedReader(fr);
            int wordCount1 = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount1 += line.trim().split("\\s+").length;
            }
            br.close();
            fr.close();
            long endFileReader = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount1);
            System.out.println("FileReader Time (ns): " + (endFileReader - startFileReader));
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }

        try {
            long startInputStreamReader = System.nanoTime();
            FileInputStream fis = new FileInputStream("largefile.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br2 = new BufferedReader(isr);
            int wordCount2 = 0;
            String line;
            while ((line = br2.readLine()) != null) {
                wordCount2 += line.trim().split("\\s+").length;
            }
            br2.close();
            isr.close();
            fis.close();
            long endInputStreamReader = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount2);
            System.out.println("InputStreamReader Time (ns): " + (endInputStreamReader - startInputStreamReader));
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }
}
