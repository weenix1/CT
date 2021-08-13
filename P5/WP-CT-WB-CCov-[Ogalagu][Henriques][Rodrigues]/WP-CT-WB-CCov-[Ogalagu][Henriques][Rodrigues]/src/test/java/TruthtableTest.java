import com.beust.jcommander.internal.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TruthtableTest {
    public static final Boolean[][] example1 = {
            {false, false, false, false},
            {false, false, true, false},
            {false, true, false, false},
            {false, true, true, false},
            {true, false, false, false},
            {true, false, true, true},
            {true, true, false, true},
            {true, true, true, false},
    };
@SuppressWarnings("unchecked")
    public static Truthtable loadExample(Boolean[][] example){
    List<Boolean>[] input = new List[example.length];
        for (var i = 0; i < example.length; i++) {
            input[i] = Arrays.asList(example[i]);
        }
        return new Truthtable(input);
    }

    @Test
    public void testConstructorSorting(){
        Boolean[][] matrix = {
                {false, false, false, false},
                {false, false, true, false},
                {false, true, false, false},
                {false, true, true, false},
                {true, false, false, false},
                {true, false, true, true},
                {true, true, false, true},
                {true, true, true, false},
        };

        var expected = example1;

        var t = loadExample(matrix);

        for (int i = 0; i < expected.length; i++) {
            var line = t.row(i);
            line.add(t.rowCondition(i));
            assertEquals(Arrays.asList(expected[i]), line);
        }

    }

    @Test
    public void testCorrectNeighbours(){
        var t = loadExample(example1);

        var expected1 = Arrays.asList(1, 2, 4);
        assertTrue(t.neighbors(0).containsAll(expected1));

        var expected2 = Arrays.asList(5, 6, 3);
        assertTrue(t.neighbors(7).containsAll(expected2));
    }

    @Test
    public void testExceptionConstructedWithNull() {
        assertThrows(
                IllegalArgumentException.class, () ->
                        new Truthtable((List<Boolean>[]) null));
    }

    @Test
    public void testExceptionConstructedWithZeroRows() {
        List[] table = new List[]{};
        assertThrows(
                IllegalArgumentException.class, () ->
                        new Truthtable(table));
    }

    @Test
    public void testExceptionConstructedWithMoreThan32Rows() {
        List<Boolean>[] table = new List[]{
                Lists.newArrayList(new Boolean[33])
        };
        assertThrows(
                IllegalArgumentException.class, () ->
                        new Truthtable(table));
    }

    @Test
    public void testCountsAtomsWithExample() {
        var table = loadExample(example1);
        assertEquals(3, table.atomCount());
    }

    @Test
    public void testCountsAtomsWithSingleAtom() {
        var singleRowWithOneAtom = new ArrayList<Boolean>();
        singleRowWithOneAtom.add(true);
        singleRowWithOneAtom.add(true); // this is the condition
        assertEquals(1, new Truthtable(singleRowWithOneAtom).atomCount());
    }

}