package JavaCore.Lv8.Lec3.w4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.FileNotFoundException;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listMin = new ArrayList<>();
        String fileDir = buffer.readLine();
        int[] arrayBytes = new int[256];
        Arrays.fill(arrayBytes, Integer.MAX_VALUE);


        try (FileInputStream input = new FileInputStream(fileDir)) {
            while(input.available()>0){
                arrayBytes[input.read()]+=1;
            }

            int minByte=arrayBytes[0];

            for (Integer element:arrayBytes) {
                if(element<minByte)
                {
                    minByte=element;
                }
            }

            for (int i = 0; i < arrayBytes.length; i++) {
                if(arrayBytes[i]==minByte)
                {
                    listMin.add(i);
                }
            }


            for (Integer element:listMin) {
                System.out.print(element+" ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
