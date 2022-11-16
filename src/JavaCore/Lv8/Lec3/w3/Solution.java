package JavaCore.Lv8.Lec3.w3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    /*    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listMax = new ArrayList<>();
        String fileDir = buffer.readLine();
        int[] arrayBytes = new int[256];
        Arrays.fill(arrayBytes,0);
        try (FileInputStream input = new FileInputStream(fileDir)) {
            while(input.available()>0){
                arrayBytes[input.read()]+=1;
            }
            int maxByte=Integer.MAX_VALUE;
            for (Integer element:arrayBytes) {
                if(element>maxByte)
                {
                    maxByte=element;
                }
            }
            for (int i = 0; i < arrayBytes.length; i++) {
                if(arrayBytes[i]==maxByte)
                {
                    listMax.add(i);
                }
            }
            for (var element:listMax) {
                System.out.print(element+" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


     */
    }
}

