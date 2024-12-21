package homework5_backup;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.IOException;

public class BackupFiles {

    public static void createBackup(String sourceDirPath) throws IOException {
        // Создаем директорию backup, если она еще не существует
        File backupDir = new File("./backup");
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        try (Stream<Path> paths = Files.walk(Paths.get(sourceDirPath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        String fileName = path.getFileName().toString();
                        Path targetPath = Paths.get(backupDir.getAbsolutePath(), fileName);

                        try {
                            Files.copy(path, targetPath);
                        } catch (IOException e) {
                            System.err.println("Ошибка при копировании файла: " + fileName);
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
