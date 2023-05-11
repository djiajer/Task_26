import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class NumbersInFile {
    public static void main(String[] args) throws IOException {
        //addNumbers();
        arrayToFile();
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
        scan.close();
        Integer[][] result = new Integer[lists.size()][];
        for (int i = 0; i < lists.size(); i++)
            result[i] = (Integer[]) lists.get(i).toArray(new Integer[lists.get(i).size()]);
        System.out.println(Arrays.deepToString(result));
    }

    public static void arrayToFile() throws IOException {
        Path path = Path.of("empty file");
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the numbers, then type \"end\" to finish");
        String forScan = scan.next();
        while (!forScan.equals("end")) {
            list.add(Integer.parseInt(forScan));
            forScan = scan.next();

        }
        scan.close();

        Integer[] line1 = list.toArray(new Integer[list.size()]);

        Collections.reverse(list);
        Integer[] line4 = list.toArray(new Integer[list.size()]);
        list.clear();

        for (Integer i : line1)
            if (i % 2 == 0) list.add(i);
        Integer[] line2 = list.toArray(new Integer[list.size()]);
        list.clear();

        for (Integer i : line1)
            if (i % 2 != 0) list.add(i);
        Integer[] line3 = list.toArray(new Integer[list.size()]);
        list.clear();


        String result = "line 1 - " + Arrays.toString(line1) + "\nline 2 - " + Arrays.toString(line2) +
                "\nline 3 - " + Arrays.toString(line3) + "\nline 4 - " + Arrays.toString(line4);

        System.out.print(result);

        Files.writeString(path, result, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
    }
}
