package TrainingInCodeWars.Strings;

/*
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 */

public class CamelWords {

    static String toCamelCase(String s) {
        String[] temp = s.split("-_");
        for (int i = 0; i < temp.length; i++) {
            if (i == 0) continue;
            char t = temp[i].charAt(0);
            //temp[i].;
        }
        String temp2 = temp.toString();

        /*
        StringBuilder stringBuilder = new StringBuilder(s);
        char temp = ' ';
        boolean flag =false;
        for (int i = 0; i < stringBuilder.length(); i++) {
            temp=stringBuilder.charAt(i);
            if (temp == '_' || temp == '-')
            {
                flag=true;
                stringBuilder.deleteCharAt(i);
            }
            if(flag){
                stringBuilder.setCharAt(i,Character.toUpperCase(stringBuilder.charAt(i)));
                flag=false;
            }
        }
        return stringBuilder.toString();

         */
        return temp2;
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));


    }
}
