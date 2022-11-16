package Level6.Lecture3.Strings;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Strings {
    public static void main(String[] args) {
    String string1 = "Hello Julia";
    String string2 = "hello julia";
        System.out.println(string1.equals(string2));
        System.out.println(string1.equalsIgnoreCase(string2));
        System.out.println(string1.startsWith("He"));
        System.out.println(string1.toLowerCase(Locale.ROOT));
        System.out.println(string1.regionMatches(2,"llo",3,3));

        String domain = "https://domen.ru/about/reviews";

        int startIndex = domain.indexOf("//");
        int endIndex =domain.indexOf("/",startIndex+2);
        String result= domain.substring(0,startIndex+2)+"javarush"+domain.substring(endIndex);
        System.out.println(result);

        // Для деления строки по словам но не сразу а постепенно с учетом разделителей.
        String stringForToken = "This string is very long and, dose not have any such elements for spacing";
        StringTokenizer strToken = new StringTokenizer(stringForToken,"n-");
        while (strToken.hasMoreTokens()){
            System.out.print(strToken.nextToken()+"-");
        }

        System.out.println();
        System.out.printf("element 1 = %3$d, 2 = %2$d, 3 = %d",1,2,3);
        String strPool = "H";
        String strPool2 = "H";
        System.out.println();
        System.out.println(strPool.hashCode());
        System.out.println(strPool2.hashCode());

    }
}
