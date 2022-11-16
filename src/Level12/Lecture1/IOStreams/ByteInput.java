package Level12.Lecture1.IOStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteInput {
    public static void main(String[] args) {
        String text = "Hello my name is Julia";

        byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
        try(ByteArrayInputStream bis = new ByteArrayInputStream(buffer))
        {
            int c;
            while ((c= bis.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
