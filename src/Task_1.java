import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) throws IOException {
        maxStringLength();
    }

    public static boolean differenceBetweenLines() throws IOException {
        Path path1 = Path.of("file1");
        Path path2 = Path.of("file2");
        Scanner scanner1 = new Scanner(path1);
        Scanner scanner2 = new Scanner(path2);
        boolean equal = false;

        while (scanner1.hasNextLine() || scanner2.hasNextLine()) {
            String line1 = scanner1.nextLine();
            String line2 = scanner2.nextLine();
            if (!line1.equals(line2)) {
                equal = true;
                System.out.println("Strings are not equal!\n" +
                        "String from " + path1.getFileName() + ": \"" + line1 + "\"\n" +
                        "String from " + path2.getFileName() + ": \"" + line2 + "\"\n");
            }
        }
        scanner1.close();
        scanner2.close();
        return equal;
    }
    public static int maxStringLength() throws IOException {
        Path path1 = Path.of("file1");
        Scanner scanner1 = new Scanner(path1);

        String maxLine = scanner1.nextLine();
        String currentLine = null;
        int maxLength = maxLine.length();
        int currentLength;

        while (scanner1.hasNextLine()) {
            currentLine = scanner1.nextLine();
            currentLength = currentLine.length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxLine = currentLine;
            }
        }
        System.out.println("Max length: " + maxLength + "\nMax line: " + maxLine);
        return maxLength;
    }

}
