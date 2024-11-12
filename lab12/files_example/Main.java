package labs.lab12.files_example;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(FileInputStream fin=new FileInputStream("input.txt");
            FileOutputStream fos=new FileOutputStream("output.txt"))
        {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}