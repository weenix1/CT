import com.beust.jcommander.internal.Lists;

import java.util.ArrayList;
import java.util.List;

public class ModifiedConditionDecisionCoverageTesting implements ConditionCoverageAlgorithm{
    @Override
    @SuppressWarnings("unchecked")
    public Truthtable create(Truthtable truthtable){
        List<List<Boolean>> rows = new ArrayList<>();

        for (int atomIterator = 0; atomIterator < truthtable.atomCount(); atomIterator++) {
            boolean atomCheck = false;

            for (int rowIterator = 0; rowIterator < truthtable.rowCount(); rowIterator++) {
                var rowAtom = truthtable.row(rowIterator).get(atomIterator);
                var rowCondition = truthtable.rowCondition(rowIterator);
                var neighbors = truthtable.neighbors(rowIterator);
                for(var neighbor : neighbors){
                    var neighborAtom = truthtable.row(neighbor).get(atomIterator);
                    var neighborCondition = truthtable.rowCondition(neighbor);

                    if(rowAtom != neighborAtom && rowCondition != neighborCondition){
                        var significantRow = Lists.newArrayList(truthtable.row(rowIterator));
                        significantRow.add(truthtable.rowCondition(rowIterator));
                        rows.add(significantRow);

                        var significantNeighbor = Lists.newArrayList(truthtable.row(neighbor));
                        significantNeighbor.add(truthtable.rowCondition(neighbor));
                        rows.add(significantNeighbor);

                        atomCheck = true;
                        break;
                    }
                }
                if (atomCheck)
                    break;
            }
        }
        return new Truthtable(rows.toArray(List[]::new));
    }
}
