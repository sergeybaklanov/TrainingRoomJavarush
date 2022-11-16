package JavaCore.Lv6.Lec13;
/*
Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке.
Внутри класса OurPresident в статическом блоке создай синхронизированный блок.
Внутри синхронизированного блока инициализируй president.
*/

public class Solution6 {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident);
    }
}

class OurPresident {
    private static OurPresident president;

    static {
        synchronized(OurPresident.class) {
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public synchronized static OurPresident getOurPresident() {
        return president;
    }
}
