package TrainingInCodeWars.Strings;

public class CentralWords {

    public static String getMiddle(String word) {
        String temp;
        int l = word.length();
        if(l%2==0) {
             temp = word.substring(l / 2 - 1, l/ 2 + 1);
        }
        else
        {
            temp = word.substring(l / 2,l/2+1);
        }
       return temp;
    }

    public static void main(String[] args) {
        System.out.println(getMiddle("test"));
        System.out.println(getMiddle("test2"));
    }
}
