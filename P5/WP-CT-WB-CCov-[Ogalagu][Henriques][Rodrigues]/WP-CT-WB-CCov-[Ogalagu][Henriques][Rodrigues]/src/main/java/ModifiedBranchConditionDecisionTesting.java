import com.beust.jcommander.internal.Lists;

import java.util.ArrayList;
import java.util.List;

public class ModifiedBranchConditionDecisionTesting implements ConditionCoverageAlgorithm {
    @Override
    @SuppressWarnings("unchecked")
    public Truthtable create(Truthtable truthtable){
        List<List<Boolean>> rows = new ArrayList<>();

        for (int i = 0; i < truthtable.rowCount(); i++) {
            var rowCondition = truthtable.rowCondition(i);
            var neighbors = truthtable.neighbors(i);
            for(var neighbor : neighbors){
                var neighborCondition = truthtable.rowCondition(neighbor);
                if(rowCondition != neighborCondition){
                    var significantRow = Lists.newArrayList(truthtable.row(i));
                    significantRow.add(truthtable.rowCondition(i));
                    rows.add(significantRow);
                }
            }
        }
        return new Truthtable(rows.toArray(List[]::new));
    }
}
