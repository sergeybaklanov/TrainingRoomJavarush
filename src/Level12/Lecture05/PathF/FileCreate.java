package Level12.Lecture05.PathF;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.createFile;

public class FileCreate {
    private Path path = null;
    private boolean flagOfCreation = false;

    private char[] buffer = new char[10000];

    public FileCreate(String address) {
        path = Path.of(address);
        try {
            createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean writeInformation(String str) {
        try (OutputStream os = new FileOutputStream(String.valueOf(path));
             OutputStreamWriter osr = new OutputStreamWriter(os)) {
            osr.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void fileRead() {
        if (flagOfCreation) {
            try (InputStream is = new FileInputStream(String.valueOf(path));
                 InputStreamReader fr = new InputStreamReader(is)) {
                while (fr.ready()) {
                    fr.read(buffer);
                    System.out.println(Arrays.toString(buffer));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File isn't found");

        }
/*
    private void createFile() {

        try {
            if (!flagOfCreation & !Files.exists(path)) {
                Files.createDirectories(path.getParent());
                createFile(path);
                flagOfCreation = true;
                System.out.println("File created completely");
            } else {
                System.out.println("Used already created file");
            }
        } catch (IOException e) {
            e.printStackTrace();
            flagOfCreation = false;
        }

 */
    }
}
