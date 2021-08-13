import java.util.*;
import java.util.stream.Collectors;
import com.beust.jcommander.internal.Lists;

public class Truthtable {
    private final List<tableRow> rows;
    private final int atomCount;

    @SafeVarargs
    public Truthtable(List<Boolean>... rows) {
        if (rows == null || rows.length == 0 || rows[0].size() > 32)
            throw new IllegalArgumentException();

        var newRows = Arrays.stream(rows)
                .map(row -> {
                    var list = Lists.newArrayList(row);
                    var condition = list.get(row.size() - 1);
                    list.remove(row.size() - 1);
                    return new tableRow(list, condition);
                })
                .distinct()
                .collect(Collectors.toList());

        this.atomCount = newRows.get(0).rowAtoms.size();

        newRows.sort(Comparator.comparingInt(a -> boolListToInt(a.rowAtoms)));
        this.rows = newRows;
    }

    public List<Boolean> row(int rowNumber){
        return this.rows.get(rowNumber).rowAtoms;
    }

    public List<Integer> neighbors(Integer lineIndex){
        List<Integer> neighbors = new ArrayList<>();
        int bitmask = 1;
        for (int i = 0; i < atomCount; i++) {
            neighbors.add(lineIndex ^ bitmask);
            bitmask = bitmask << 1;
        }
        return neighbors;
    }

    public int rowCount(){
        return rows.size();
    }

    public boolean rowCondition(int row) {
        return rows.get(row).condition;
    }

    public int atomCount() {
        return atomCount;
    }

    public static int boolListToInt(List<Boolean> list) {
        int n = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            n = (n << 1) + (list.get(i) ? 1 : 0);
        }
        return n;
    }

    public static List<Boolean> intToBoolList(int number, int bitCount) {
        var list = new ArrayList<Boolean>();
        int conditions = number;
        for (int i = 0; i < bitCount; i++) {
            boolean bit = (conditions & 1) == 1;
            conditions = conditions >> 1;
            list.add(0, bit);
        }
        return list;
    }

    private class tableRow {

        /**
         * The integers in the list consists of the atoms in the row and the boolean is the condition
         */
        final List<Boolean> rowAtoms;
        final Boolean condition;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            tableRow row = (tableRow) o;
            return Objects.equals(rowAtoms, row.rowAtoms) && Objects.equals(condition, row.condition);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowAtoms, condition);
        }

        @Override
        public String toString() {
            return "Row:" +
                    "atoms=" + rowAtoms +
                    ", condition=" + condition;

        }

        public tableRow(List<Boolean> atoms, Boolean condition) {
            this.rowAtoms = atoms;
            this.condition = condition;
        }
    }
}

