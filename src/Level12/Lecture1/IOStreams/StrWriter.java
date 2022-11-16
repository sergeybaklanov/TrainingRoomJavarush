package Level12.Lecture1.IOStreams;

import java.io.StringWriter;

public class StrWriter {
    public static void main(String[] args) {
        StringWriter writer = new StringWriter();
        writer.write("Hello");
        writer.write(String.valueOf(123));
        writer.write("\nAgain");

        String result = writer.toString();
        System.out.println(result);
    }
}
