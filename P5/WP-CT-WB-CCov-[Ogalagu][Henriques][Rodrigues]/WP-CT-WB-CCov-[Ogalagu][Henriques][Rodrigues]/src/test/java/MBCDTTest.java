import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MBCDTTest {
    @Test
    public void correctMBUE() {
        var table = TruthtableTest.loadExample(TruthtableTest.example1);
        var mbue = new ModifiedBranchConditionDecisionTesting();
        var newTable = mbue.create(table);
        assertEquals(6, newTable.rowCount());

    }
}
