package JavaCore.Lv8.Lec11.w4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private static final Character[] ENGLISH_CHARACTERS_ARRAY = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'
            , 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'
            , 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
private static final Set<Character> ENGLISH_CHARACTERS_LIST = new HashSet<>(Arrays.asList(ENGLISH_CHARACTERS_ARRAY));
    public static void main(String[] args) {
        int countEnglishChar=0;
        if(args.length>0){
            try(FileReader input = new FileReader(args[0])) {
                while(input.ready()){
                        char readChar = (char) input.read();
                        if(ENGLISH_CHARACTERS_LIST.contains(readChar)){
                            countEnglishChar++;
                        }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(countEnglishChar);
    }
}
