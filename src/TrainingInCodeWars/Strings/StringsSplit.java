/*Complete the solution so that it splits the string
into pairs of two characters. If the string contains
an odd number of characters then it should replace the
missing second character of the final pair with an
underscore ('_').

        Examples:

        * 'abc' =>  ['ab', 'c_']
        * 'abcdef' => ['ab', 'cd', 'ef']
 */
package TrainingInCodeWars.Strings;

import java.util.Arrays;

public class StringsSplit {
    public static void main(String[] args) {
        String s = "abcde";
/*
        if(s.length()%2!=0)
        {
            s=s.concat("_");
        }
        String[] tempString = new String[s.length()/2];
        int j=0;
        for (int i = 0; i < tempString.length ; i++) {
            tempString[i]=s.substring(j,j+2);
            j=j+2;
        }
        System.out.println(Arrays.toString(tempString));


 */
        System.out.println(Arrays.toString(solution(s)));
    }


    public static String[] solution(String s) {
      return s.length() % 2 == 0 ? s.split("(?<=\\G.{2})")
      : (s + "_").split("(?<=\\G.{2})");
    }


}
