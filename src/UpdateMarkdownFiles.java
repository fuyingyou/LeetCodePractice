import java.io.*;
import java.nio.file.*;
import java.util.List;

public class UpdateMarkdownFiles {
    public static void main(String[] args) {
        String folderPath = "F:\\fyyblog\\source\\_posts\\JUC"; // 替换为实际的绝对路径
        File folder = new File(folderPath);

        processFilesInFolder(folder);
    }

    private static void processFilesInFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        processFilesInFolder(file); // 递归处理子文件夹
                    } else if (file.isFile() && file.getName().toLowerCase().endsWith(".md")) {
                        try {
                            deleteLinesInFile(file, 12, 22);
                            System.out.println("成功更新文件：" + file.getName());
                        } catch (IOException e) {
                            System.out.println("更新文件时出错：" + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void deleteLinesInFile(File file, int startLine, int endLine) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        lines.subList(startLine - 1, endLine).clear();
        Files.write(file.toPath(), lines);
    }
}
