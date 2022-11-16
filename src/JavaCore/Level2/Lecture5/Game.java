package JavaCore.Level2.Lecture5;

public class Game {
    public enum Color {WHITE, BLACK}

    ;
/*
    public static void main(String[] args) {
        var board = ChessBoard.getBoard();
        //  board.cells[0][3] = new King(Color.WHITE);
        //   board.cells[0][4] = new Queen(Color.WHITE);
    }

 */

    class King {
        public King(Game.Color color) {
        }

        void kingMove() {
            // код, решающий,
            // как пойдет
            // король
        }
    }

    class Queen extends ChessItem {
        void queenMove() {
            // код, решающий,
            // как пойдет ферзь
        }

        @Override
        public void draw() {

        }
    }

    class Rook extends ChessItem {
        void rookMove() {
            // код, решающий,
            // как пойдет ладья
        }

        @Override
        public void draw() {

        }
    }

    class Knight extends ChessItem {
        void knightMove() {
            // код, решающий,
            // как пойдет конь
        }

        @Override
        public void draw() {

        }
    }

    class Bishop extends ChessItem {
        void bishopMove() {
            // код, решающий,
            // как пойдет слон
        }

        @Override
        public void draw() {

        }
    }

    class Pawn extends ChessItem {
        void pawnMove() {
            // код, решающий,
            // как пойдет пешка
        }

        @Override
        public void draw() {

        }
    }
}
