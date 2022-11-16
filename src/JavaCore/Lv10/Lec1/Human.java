package JavaCore.Lv10.Lec1;

import java.io.BufferedReader;
import java.io.PrintWriter;

class Human {
    Cat cat;
    Dog dog;


    public void save(PrintWriter writer) throws Exception {

        String isCatPresent = cat != null ? "YES" : "NO";

        writer.println(isCatPresent);
        writer.flush();

        if (cat != null) {
            cat.save(writer);
        }

        String isDogPresent = dog != null ? "YES" : "NO";

        writer.println(isDogPresent);
        writer.flush();

        if (dog != null) {
            dog.save(writer);
        }
    }

    public void load(BufferedReader reader) throws Exception {
        String isCatPresent = reader.readLine();
        if (isCatPresent.equals("YES")) {
            cat = new Cat();
            cat.load(reader);
        }

        String isDogPresent=reader.readLine();
        if(isDogPresent.equals("YES")){
            dog=new Dog();
            dog.load(reader);
        }
    }
}
