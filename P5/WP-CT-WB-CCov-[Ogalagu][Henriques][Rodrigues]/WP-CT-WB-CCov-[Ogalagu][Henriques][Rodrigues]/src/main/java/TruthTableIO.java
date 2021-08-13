import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TruthTableIO {

    public Truthtable read(File file) {
        try (Stream<String> stream = Files.lines(file.toPath())) {
            @SuppressWarnings("unchecked")
            var rows = stream
                    .filter(line -> Pattern.compile("\\|( *([10]) *\\|)+").matcher(line).matches())
                    .map((line) -> {
                        var cleaned = line.replaceAll("[^10]", "");

                        var result = new ArrayList<Boolean>();
                        for (String col : cleaned.split("")) {
                            if (col.equals("1")) {
                                result.add(true);
                            } else if (col.equals("0")) {
                                result.add(false);
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        return result;
                    })
                    .toArray(size -> (List<Boolean>[]) new List[size]);
            return new Truthtable(rows);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public void write(File file, Truthtable truthtable) {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {

            var header = new String[truthtable.atomCount() + 1];
            bw.write("| " + String.join(" | ", header) + " |");
            bw.newLine();

            var separator = new String[truthtable.atomCount() + 1];
            Arrays.fill(separator, "--");
            bw.write("| " + String.join(" | ", separator) + " |");
            bw.newLine();
            for (int i = 0; i < truthtable.rowCount(); i++) {
                var row = truthtable.row(i);
                var line = row.stream()
                        .map(cell -> cell ? "1" : "0")
                        .toArray(String[]::new);

                bw.write("| " + String.join(" | ", line) + " | " + truthtable.rowCondition(i) + " |");
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
