package JavaCore.Lv9.Lec3.w5;

import java.util.HashMap;
import java.util.Map;

/*
Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada

Требования:
•	Класс Solution должен содержать public static поле countries типа Map<String, String>.
•	В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
•	Класс Solution должен содержать интерфейс RowItem.
•	Класс Solution должен содержать интерфейс Contact.
•	Класс Solution должен содержать интерфейс Customer.
•	Класс DataAdapter должен реализовывать интерфейс RowItem.
•	Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
•	Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact), который инициализирует поля contact и customer.
•	В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args) {

    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: call to://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

    public static class DataAdapter implements RowItem{
        private final Customer customer;
        private final Contact contact;
        private String[] contactName=new String[2];

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
            contactName=contact.getName().split(", ");
        }


        @Override
        public String getCountryCode() {
            return countries.get(customer.getCountryName());
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contactName[1] ;
        }

        @Override
        public String getContactLastName() {
            return contactName[0];
        }

        @Override
        public String getDialString() {
            String myString=contact.getPhoneNumber().replaceAll("()-","");
            StringBuilder  str = new StringBuilder(contact.getPhoneNumber());

            for (int i = str.length()-1; i >=0; i--) {
                if(str.charAt(i)=='-'||str.charAt(i)==')'||str.charAt(i)=='(')
                {
                    str.deleteCharAt(i);
                }
            }
            String res= String.format("callto://%s",str);
            return res;
        }
    }
}