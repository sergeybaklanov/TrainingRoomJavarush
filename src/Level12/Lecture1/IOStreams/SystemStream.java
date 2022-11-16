package Level12.Lecture1.IOStreams;

import java.io.*;

public class SystemStream {
    public static void main(String[] args) {
        try (
                InputStream stream = System.in;
                InputStreamReader isr = new InputStreamReader(stream);
                BufferedReader br = new BufferedReader(isr);
                FileWriter fr = new FileWriter("D:\\LessonTry\\Output.txt")) {
            String input;
            while(!((input=br.readLine()).equals("exit")))
            fr.write(input+"\t");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
