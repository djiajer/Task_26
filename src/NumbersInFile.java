import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumbersInFile {
    public static void main(String[] args) throws IOException {
        addNumbers();
    }

    public static void addNumbers() throws IOException {
        Path path = Path.of("numbers");
        Scanner scan = new Scanner(path);
        //while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] nums = line.split("[\s,?!]+");
            List<Integer> list = new ArrayList<>();
            for (String num : nums) {
                try {
                    int i = Integer.parseInt(num);
                    list.add(i);
                } catch (NumberFormatException e) {}
            }


        System.out.println(list);
        //}
    }
}
