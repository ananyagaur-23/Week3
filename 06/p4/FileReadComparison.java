import java.io.*;
public class FileReadComparison{
    public static void readUsingFileReader(String path) throws IOException{
        FileReader fr = new FileReader(path);
        long start = System.nanoTime();
        while (fr.read() != -1);
        long end = System.nanoTime();
        fr.close();
        System.out.printf("FileReader Time: %.2f ms\n",(end-start)/1e6);
    }
    public static void readUsingInputStreamReader(String path) throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
        long start = System.nanoTime();
        while(isr.read() != -1);
        long end = System.nanoTime();
        isr.close();
        System.out.printf("InputStreamReader Time: %.2f ms\n",(end-start)/1e6);
    }
    public static void main(String[] args) throws IOException{
        String filePath = "src/sample.txt";

        System.out.println("Reading: "+filePath);
        readUsingFileReader(filePath);
        readUsingInputStreamReader(filePath);
    }
}