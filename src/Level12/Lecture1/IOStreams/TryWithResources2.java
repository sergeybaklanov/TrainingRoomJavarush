package Level12.Lecture1.IOStreams;

import java.io.*;

public class TryWithResources2 {
    public static void main(String[] args) {
        String inputFile = "D:\\LessonTry\\Input.txt";
        String outputFile = "D:\\LessonTry\\Output.txt";
        int count = 0;


        try (InputStream is = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
                FileWriter fiw = new FileWriter(outputFile)) {

            //char[] buffer = new char[2000];

            int real;
            while (br.ready()) {
               String temp =br.readLine();
               fiw.write(temp);
                System.out.print("\nHello");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
