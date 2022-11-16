package JavaCore.Lv6.Lec13;

import java.util.ArrayList;
import java.util.List;

/*
Заметки
Асинхронность выполнения нитей.
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью), которая в
методе run 1000 раз (index = 0-999) сделает следующие действия:
2.1. Используя метод addNote добавит заметку с именем [getName() + "-Note" + index],
 например, при index=4
"Thread-0-Note4"
2.2. Заснет на 1 миллисекунду
2.3. Используя метод removeNote удалит заметку
2.4. В качестве параметра в removeNote передай имя нити - метод getName()

Требования:
•	Класс Solution должен содержать public static класс NoteThread.
•	Класс NoteThread должен быть нитью.
•	В методе run класса NoteThread должен быть цикл.
•	Метод run класса NoteThread должен 1000 раз вызывать метод addNote c
 параметром (getName() + "-Note" + index).
•	Метод run класса NoteThread должен 1000 раз вызывать Thread.sleep() c
параметром (1).
•	Метод run класса NoteThread должен 1000 раз вызывать метод removeNote c параметром (getName()).
*/
public class Solution3 {
    public static void main(String[] args) throws InterruptedException {

        NoteThread note = new NoteThread();
        note.start();
        note.join();
        NoteThread note2 = new NoteThread();
        note2.start();
    }

    public static class NoteThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 999; i++) {

                    //add note in List
                    Note.addNote(getName() + "-Note" + i);

                    Thread.sleep(1);

                    //delete note from list
                    Note.removeNote(getName());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            synchronized (notes) {
                notes.add(0, note);
            }
        }

        public static void removeNote(String threadName) {
            synchronized (notes) {
                String note = notes.remove(0);
                if (note == null) {
                    System.out.println("Другая нить удалила нашу заметку");
                } else if (!note.startsWith(threadName)) {
                    System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
                } else {
                    System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
                }
            }
        }


    }
}
