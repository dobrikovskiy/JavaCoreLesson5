package homework5_tic_tac_toe;

public class Main {
    public static void main(String[] args) {
        int[] initialState = {0, 1, 2, 3, 0, 1, 2, 3, 0}; // Пример начального состояния доски
        Board board = new Board(initialState);
        String filename = "tictactoe_data.dat"; // Имя файла для сохранения

        BoardSaver.saveBoardToFile(board, filename);
    }
}
