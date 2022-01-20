import java.io.*;
import java.util.Date;

public class Main {
    public static String root = "Games/";
    public static String log = root + "temp/temp.txt";
    public static String projectStructure[] = {
            root + "src/",
            root + "src/main/",
            root + "src/main/Main.java",
            root + "src/main/Utils.java",
            root + "src/test/",
            root + "res/",
            root + "res/drawables/",
            root + "res/vectors/",
            root + "res/icons/",
            root + "savegames/",
            root + "temp/",
            root + "temp/temp.txt",
    };
    public static void main(String[] args) {
        StringBuilder logInit = new StringBuilder();
        Date date = new Date();
        File dir = new File(root);
        if (!dir.isDirectory()) {
            if (dir.mkdir()) {
                logInit.append(date).append(" - Главная директория ").append(root).append(" создана\n");
            } else {
                logInit.append(date).append(" - Главный каталог ").append(root).append(" найден\n");
            }
        }
        for (String path : projectStructure) {
             dir = new File(path);
             if (path.contains(".")) {
                 try {
                     dir.createNewFile();
                     logInit.append(date).append(" - Файл ").append(path).append(" успешно создан\n");
                 } catch (IOException err) {
                     logInit.append(date).append(" - Ошибка создания файла ").append(path).append("\n");
                 }
             } else {
                 if (dir.mkdir()) {
                     logInit.append(date).append(" - Папка ").append(path).append(" успешно создана.\n");
                 } else {
                     logInit.append(date).append(" - Ошибка создания папки ").append(path).append("\n");
                 }
             }
        }
        try (FileWriter writer = new FileWriter(log, false)) {
            writer.write(logInit.toString());
            writer.flush();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
