import com.beust.jcommander.internal.Lists;

import java.util.List;

public enum SupportedAlgorithm {
    MCDC, MBCDT;

    public static final List<String> allowedAlgorithms = Lists.newArrayList("mcdc", "mbcdt");

    public static boolean isSupported(String algorithm){
        return allowedAlgorithms.contains(algorithm);
    }

    public ConditionCoverageAlgorithm createInstance(){
        switch (this) {
            case MCDC:
                return new ModifiedConditionDecisionCoverageTesting();
            case MBCDT:
                return new ModifiedBranchConditionDecisionTesting();
        }
        throw new IllegalArgumentException("The Algorithm is not yet implemented");
    }
}
