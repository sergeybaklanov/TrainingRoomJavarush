package Level12.Lecture1.IOStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {


    public static void main(String[] args) {
        String inputFile = "D:\\LessonTry\\Input.txt";
        String outputFile = "D:\\LessonTry\\Output.txt";
        int count=0;
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile,false)) {

            byte[] buffer = new byte[18*1024];
            while (fis.available() > 0) {
                count++;
                int real = fis.read(buffer);
                fos.write(buffer, 0, real);
                System.out.println("real= "+real);
            }
            System.out.println("File written");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("count= "+count);

    }
}
