package Level6.Lecture2.DecodingFormats;

public class Decoding {
    public static void main(String[] args) {

        decoding(967, 16);
        decoding(967, 2);
        decoding(967, 8);
        decoding(967, 10);
    }

    public static void decoding(int digit, int systemOfCode) {
        StringBuilder outTemp = new StringBuilder();
        while (digit != 0) {
            double temp = digit % systemOfCode;
            digit = digit / systemOfCode;
            
            if (systemOfCode == 16) {
                switch ((int) temp) {
                    case 10 -> outTemp.append("A");
                    case 11 -> outTemp.append("B");
                    case 12 -> outTemp.append("C");
                    case 13 -> outTemp.append("D");
                    case 14 -> outTemp.append("E");
                    case 15 -> outTemp.append("F");
                    default -> outTemp.append((int) temp);
                }
            }
            /*
            if (systemOfCode == 16) {
                switch ((int) temp) {
                    case 10:
                        outTemp = outTemp.append("A");
                        break;
                    case 11:
                        outTemp = outTemp.append("B");
                        break;
                    case 12:
                        outTemp = outTemp.append("C");
                        break;
                    case 13:
                        outTemp = outTemp.append("D");
                        break;
                    case 14:
                        outTemp = outTemp.append("E");
                        break;
                    case 15:
                        outTemp = outTemp.append("F");
                        break;
                    default:
                        outTemp = outTemp.append(Integer.toString((int) (temp)));
                }
            }
            */
             else {
                outTemp.append((int) (temp));
            }
        }
        // Symbol of coding System;
        StringBuilder codingSystemCharacter = switch (systemOfCode) {
            case 2 -> new StringBuilder("0b");
            case 8 -> new StringBuilder("0");
            case 10 -> new StringBuilder("");
            case 16 -> new StringBuilder("0x");
            default -> new StringBuilder(systemOfCode + "x");
        };

        outTemp.reverse();
        codingSystemCharacter.append(outTemp);

        System.out.println(codingSystemCharacter);
    }
}