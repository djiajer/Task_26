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
        List<List> lists = new ArrayList<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] nums = line.split("[\s,.?!]+");
            List<Integer> numbers = new ArrayList<>();
            for (String num : nums) {
                try {
                    int i = Integer.parseInt(num);
                    numbers.add(i);
                } catch (NumberFormatException e) {}
            }
            lists.add(numbers);
        }
        Integer[][] result = new Integer[lists.size()][];
        for (int i = 0; i < lists.size(); i++)
            result[i] = (Integer[]) lists.get(i).toArray(new Integer[lists.get(i).size()]);
        System.out.println(Arrays.deepToString(result));
    }
}
