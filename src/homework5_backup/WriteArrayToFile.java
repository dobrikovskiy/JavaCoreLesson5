package homework5_backup;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteArrayToFile {

    public static void writeArray(int[] array, String filePath) throws IOException {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(filePath));

            for (int value : array) {
                out.writeByte(value); // Записываем одно число в виде одного байта
            }
        } finally {
            if (out != null) {
                out.close(); // Закрываем поток
            }
        }
    }
}
