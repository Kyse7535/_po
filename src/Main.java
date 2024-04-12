import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<String> getValuesFromFile(String filepath, String csvSplitBy) {
        String line;
        List<String> elements = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                for (String field : data) {
                   elements.add(field);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\KTT4\\Desktop\\projects\\calculatrice\\src\\number.csv";
        String line = "";
        String csvSplitBy = ",";
        Main main = new Main();

        List<String> elements = main.getValuesFromFile(csvFile, csvSplitBy);

        List<Integer> e = elements.stream().map(Integer::parseInt).toList();
        IntEvaluator intEvaluator = new IntEvaluator();
        intEvaluator.calcul(e, "+");
        System.out.println(intEvaluator.getResponse());
    }
}
