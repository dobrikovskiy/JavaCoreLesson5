package homework5_tic_tac_toe;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс для сохранения состояния доски в файл.
 */
public class BoardSaver {
    /**
     * Сохраняет состояние доски в указанный файл.
     *
     * @param board Доска, состояние которой необходимо сохранить.
     * @param filename Имя файла, в который будет сохранена доска.
     */
    public static void saveBoardToFile(Board board, String filename) {
        byte[] data = packBoard(board.getBoard());
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(data);
            System.out.println("Данные записаны в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    /**
     * Упаковывает массив значений состояния доски в байты.
     *
     * @param values Массив значений состояния досок.
     * @return Байтовый массив, содержащий упакованные данные.
     */
    private static byte[] packBoard(int[] values) {
        if (values.length != 9) {
            throw new IllegalArgumentException("Доска должна состоять из 9 элементов.");
        }

        byte[] result = new byte[3];
        for (int i = 0; i < 9; i++) {
            int bitIndex = i * 2;
            int value = values[i];
            if (value < 0 || value > 3) {
                throw new IllegalArgumentException("Значение должно быть в диапазоне [0, 3].");
            }

            // Заполняем соответствующий бит в байте
            result[bitIndex / 8] |= (byte) ((value & 0x03) << (6 - (bitIndex % 8)));
        }
        return result;
    }
}
