package JavaCore.Lv10.Lec7.w5.External;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Solution implements Externalizable, Cloneable {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Solution{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", privateInformation='" + privateInformation + '\'' +
                '}';
    }

    private int age;
    private String privateInformation;

    public Solution(String firstName, String lastName, int age, String privateInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.privateInformation = privateInformation;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(firstName);
        out.writeObject(lastName);
        out.writeInt(age);
        System.out.println("ENCRYPTED "+encryptInfo(privateInformation));
        out.writeObject(encryptInfo(privateInformation));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        age = (int) in.readInt();
        privateInformation = decryptInfo((String) in.readObject());
        System.out.println("DECRYPTED "+privateInformation);
    }

    private String encryptInfo(String privateInformation) {
        return Base64.getEncoder().encodeToString(privateInformation.getBytes(StandardCharsets.UTF_8));
    }

    private String decryptInfo(String privateInformation) {
        return new String (Base64.getDecoder().decode(privateInformation));
    }

    public static void main(String[] args) {
        Solution Sergey = new Solution("Sergey", "Baklanov", 32, "Has a wife");

        try (OutputStream output = new FileOutputStream("EncryptingFile.txt");
             ObjectOutputStream write = new ObjectOutputStream(output);
             InputStream input = new FileInputStream("EncryptingFile.txt");
             ObjectInputStream read = new ObjectInputStream(input)) {

            Solution oldUser = (Solution) Sergey.clone();

            Sergey.writeExternal(write);

            Sergey.readExternal(read);
            System.out.println(oldUser);
            System.out.println(Sergey);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
