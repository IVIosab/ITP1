package labs.lab12.task04;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void saveImage(String imageUrl) {
        InputStream is = null;
        OutputStream os = null;

        try {
            URL url = new URL(imageUrl);
            String fileName = url.getFile();
            String destName = "./figures" + fileName.substring(fileName.lastIndexOf("/"));
            System.out.println(destName);

            is = url.openStream();
            os = new FileOutputStream(destName);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

        } catch (MalformedURLException e) {
            System.out.println("malformed url: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("failed to close input stream: " + e.getMessage());
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    System.out.println("failed to close output stream: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        saveImage("image");
    }
}
