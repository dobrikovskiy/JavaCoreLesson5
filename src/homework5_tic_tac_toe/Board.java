package homework5_tic_tac_toe;

/**
 * Класс для представления доски игры "Крестики-нолики".
 */
public class Board {
    private final int[] board;

    /**
     * Конструктор для создания объекта Board.
     *
     * @param board Массив состояний ячеек доски (должен содержать 9 элементов).
     * @throws IllegalArgumentException Если массив не содержит 9 элементов.
     */
    public Board(int[] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException("Доска должна состоять из 9 элементов.");
        }
        this.board = board;
    }

    /**
     * Получает состояние доски.
     *
     * @return Массив состояний ячеек доски.
     */
    public int[] getBoard() {
        return board;
    }
}
