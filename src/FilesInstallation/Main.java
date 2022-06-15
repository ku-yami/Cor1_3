package FilesInstallation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File newDir = new File("C:\\Games");
        File[] dirs = {
                new File(newDir, "src"),
                new File(newDir, "res"),
                new File(newDir, "savegames"),
                new File(newDir, "temp"),
                new File(newDir + "\\src", "main"),
                new File(newDir + "\\src", "test"),
                new File(newDir + "\\res", "drawables"),
                new File(newDir + "\\res", "vectors"),
                new File(newDir + "\\res", "icons"),
        };
        File[] files = {
                new File(newDir + "\\src\\main", "Main.java"),
                new File("\\src\\main", "Utils.java"),
                new File(newDir + "\\temp", "temp.txt"),
        };

        StringBuilder log = new StringBuilder();
        if (!newDir.exists()) {
            log.append("Папки ")
                    .append(newDir.getName())
                    .append(" не существует. Создание папки:\n")
                    .append(makeDir(newDir));
        }
        for (File dir : dirs) {
            log.append(makeDir(dir));
        }

        try {
            for (File file : files) {
                log.append(makeFile(file));
            }
            String logFilePath = newDir + "\\temp\\temp.txt";
            FileWriter fw = new FileWriter(logFilePath);
            fw.append(log);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String makeDir(File dir) {
        return (dir.mkdir() ? "Успешное создание папки " : "Не удалось создать папку ")
                + dir + '\n';
    }

    public static String makeFile(File file) throws IOException {
        return (file.createNewFile() ? "Успешное создание файла " : "Не удалось создать файл ")
                + file + '\n';
    }
}
