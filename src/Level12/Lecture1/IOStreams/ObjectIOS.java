package Level12.Lecture1.IOStreams;

import java.io.*;

public class ObjectIOS {
    public static void main(String[] args) {
        User user = new User("Sergey", 32, 120);
        String address = "D:\\LessonTry\\Object\\FileObject.txt";

        try (OutputStream os = new FileOutputStream(address); ObjectOutputStream obos = new ObjectOutputStream(os);
             FileInputStream fis = new FileInputStream(address); ObjectInputStream obis = new ObjectInputStream(fis)) {

            obos.writeObject(user);
            User newUser =(User) obis.readObject();
            System.out.println(user);
            System.out.println("Next New User from file");
            System.out.println(newUser);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class User implements Serializable{
    private String name;
    private int age;
    private int power;

    public User(String name, int age, int power) {
        this.name = name;
        this.age = age;
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", power=" + power +
                '}';
    }
}