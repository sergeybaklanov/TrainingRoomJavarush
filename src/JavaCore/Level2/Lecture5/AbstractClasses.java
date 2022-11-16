package JavaCore.Level2.Lecture5;

public class AbstractClasses {

    public static void main(String[] args) {

    }
}

abstract class Chess {
    public int x,y;
    private int value;

    public int getValue(){
        return value;
    }
    public abstract void draw();

}
/*
public class ChessBoard
{
    private static ChessBoard board = new ChessBoard();
    public static ChessBoard getBoard()
    {
        return board;
    }

    public ChessItem[][] cells = new ChessItem[8][8];
   }
 */

