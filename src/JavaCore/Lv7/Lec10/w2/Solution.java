package JavaCore.Lv7.Lec10.w2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997

Требования:
•	Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
•	Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
•	При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
•	При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
•	При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
•	При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
•	Метод main класса Solution должен содержать оператор switch по значению args[0].
•	Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        if (args == null || args.length < 1) {
            throw new RuntimeException();
        }
        try {
            switch (args[0]) {
                // При параметре -с программа должна добавлять всех людей с заданными параметрами
                // в конец списка allPeople, и выводить id каждого (index) на экран.

                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            Date birthDate = inputFormat.parse(args[i + 2]);
                            Person person = sex.equals("м") ? Person.createMale(name, birthDate) : Person.createFemale(name, birthDate);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                    break;
                //При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
                //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                case "-u":

                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            Date date = inputFormat.parse(args[i + 3]);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                            allPeople.get(id).setBirthDate(date);
                        }
                    }
                    for (var per: allPeople) {
                        System.out.println(per);
                    }


                    break;
                //При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person person = allPeople.get(Integer.parseInt(args[i]));
                            person.setSex(null);
                            person.setName(null);
                            person.setBirthDate(null);
                        }
                    }
                    break;
                //При параметре -i программа должна выводить на экран данные о всех людях с заданными id
                // по формату указанному в задании.
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person person = allPeople.get(Integer.parseInt(args[i]));
                            String name = person.getName();
                            String date = outputFormat.format(person.getBirthDate());
                            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                            //Миронов м 15-Apr-1990
                            System.out.printf("%s %s %s\n", name, sex, date);
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
