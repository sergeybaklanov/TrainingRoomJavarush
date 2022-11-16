package JavaCore.Lv7.Lec10.w1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
CRUD - Create, Read, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-r id
-u id name sex bd
-d id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -r:
Миронов м 15-Apr-1990

Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
Например, при запуске программы c параметрами:
-c name sex bd
получим в методе main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать в поле Program arguments в меню Run -> Edit Configurations.

Требования:
•	Класс Solution должен содержать public static поле allPeople типа List<Person>.
•	Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
•	При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка
 allPeople, и выводить id (index) на экран.
•	При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату
указанному в задании.
•	При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
•	При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    //Create date format for
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        Person person;
        Date birthDate;

        if (args == null || args.length < 1) {
            throw new RuntimeException();
        }
        switch (args[0]) {
            case "-c":
                birthDate = simpleDateFormat.parse(args[3]);
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], birthDate);
                } else {
                    person = Person.createFemale(args[1], birthDate);
                }
                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                for (var people : allPeople) {
                    System.out.println(people);
                }
            break;
            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person != null) {
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " +
                            simpleDateFormat2.format(person.getBirthDate()));
                }
                System.out.println(allPeople.size() - 1);
                for (var people : allPeople) {
                    System.out.println(people);
                }
                break;
            case "-u":
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person == null) {
                    throw new NullPointerException();
                }
                person.setName(args[2]);
                person.setSex((args[3].equals("м")) ? Sex.MALE : Sex.FEMALE);
                person.setBirthDate(simpleDateFormat.parse(args[4]));
                break;

            case "-d":

                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setBirthDate(null);
                person.setSex(null);
                break;
        }
    }
}
