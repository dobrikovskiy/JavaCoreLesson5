package homework5_backup;

// Импортируем нужные классы
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Директория, которую будем бэкапить
        String sourceDirectory = "/backup";

        // Массив чисел для записи в файл
        int[] numbers = {0, 1, 2, 3, 0, 1, 2, 3, 0};

        // Создаём резервную копию
        BackupFiles.createBackup(sourceDirectory);

    }
}
