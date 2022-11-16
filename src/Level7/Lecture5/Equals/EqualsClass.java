package Level7.Lecture5.Equals;

import java.util.Objects;

public class EqualsClass {
    public static void main(String[] args) {

        Person p1 = new Person("Sergey", 31);
        Person p2 = new Person("Sergey", 31);

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());

    }
}

class Person {
    int age;
    String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }


    /*

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            return false;

        Person temp = (Person) obj;

        if (this.age != temp.age)
            return false;

        if (temp.name == null)
            return this.name == null;

        return this.name.equals(temp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

 */
}
