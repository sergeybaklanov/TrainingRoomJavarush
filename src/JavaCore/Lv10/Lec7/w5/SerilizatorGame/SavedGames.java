package JavaCore.Lv10.Lec7.w5.SerilizatorGame;

import java.io.*;
import java.util.Arrays;

public class SavedGames implements Serializable {
   // @Serial
    //private static final long serialVersionUID = 1L;

    private String[] territoryInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedGames)) return false;
        SavedGames that = (SavedGames) o;
        return Arrays.equals(territoryInfo, that.territoryInfo) && Arrays.equals(resourceInfo, that.resourceInfo) && Arrays.equals(diplomacyInfo, that.diplomacyInfo);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(territoryInfo);
        result = 31 * result + Arrays.hashCode(resourceInfo);
        result = 31 * result + Arrays.hashCode(diplomacyInfo);
        return result;
    }

    private String[] resourceInfo;
    private String[] diplomacyInfo;

    public SavedGames(String[] territoryInfo, String[] resourceInfo, String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
        this.territoryInfo = territoryInfo;
        this.resourceInfo = resourceInfo;
    }

    public String[] getTerritoryInfo() {
        return territoryInfo;
    }

    public void setTerritoryInfo(String[] territoryInfo) {
        this.territoryInfo = territoryInfo;
    }

    public String[] getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(String[] resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGames{" +
                "territoryInfo=" + Arrays.toString(territoryInfo) +
                ", resourceInfo=" + Arrays.toString(resourceInfo) +
                ", diplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }


    public static void main(String[] args) {

        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        SavedGames savedGame = new SavedGames(territoryInfo, resourcesInfo, diplomacyInfo);

        try(OutputStream writeToFile = new FileOutputStream ("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec7\\w5\\SerilizatorGame\\SavedGame.txt");
        InputStream readFromFile = new FileInputStream("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec7\\w5\\SerilizatorGame\\SavedGame.txt")) {
            System.out.println("Before = "+savedGame);

            savedGame.saveTheGame(writeToFile);

            SavedGames loadedGame= loadTheGame(readFromFile);
            System.out.println("loadedGame = " + loadedGame);

            System.out.println(savedGame.equals(loadedGame));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void saveTheGame(OutputStream outputStream) {
        try (ObjectOutputStream write = new ObjectOutputStream(outputStream)) {
            write.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SavedGames loadTheGame(InputStream inputStream) {
        SavedGames oldGame = null;
        try (ObjectInputStream load = new ObjectInputStream(inputStream)) {
            oldGame = (SavedGames) load.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(oldGame==null){
            throw new NullPointerException("Couldn't load saved game from file, return null");
        }
        return oldGame;
    }

}
