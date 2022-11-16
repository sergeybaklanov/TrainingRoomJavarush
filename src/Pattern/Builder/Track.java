package Pattern.Builder;

import java.util.Arrays;

public class Track {
    public static void main(String[] args) {
        String myString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(CountingDuplicates.duplicateCount(myString));
    }
    public static class CountingDuplicates {
        public static int duplicateCount(String text) {
            char[] element = text.toLowerCase().toCharArray();
            int[] counter = new int[element.length];
            int maxNum = 0;
            for (int i = 0; i < element.length; i++) {
                for (int j = 0; j < element.length; j++) {
                    if (element[i] == element[j])
                        counter[i]++;
                    if (counter[i] > maxNum) {
                        maxNum = counter[i];
                    }
                }
            }
            return maxNum==1?0:maxNum;
        }
    }
}
