package TrainingInCodeWars.Strings;

import java.util.Arrays;
import java.util.List;

public class BinaryString {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int size = binary.size();

        int res =0;
        for (int i = 0; i < size; i++) {
            if (binary.get(i)!=0)
            res+=(int)Math.pow(2.0,size-(i+1));
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0, 0, 1, 1)));


    }
}
