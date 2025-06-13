package Project.QualiCheck.Standard;

import java.util.*;

public class DoubleQualityStandard {
    private final String name;
    private final double standardValue;

    private static final HashMap<String, DoubleQualityStandard> standards = new HashMap<String, DoubleQualityStandard>();

    public static void initializeStandard() {
        register(new DoubleQualityStandard("PROTEIN", 2.7));           // Default
        register(new DoubleQualityStandard("MIN_FAT", 3.0));
        register(new DoubleQualityStandard("MAX_FAT_FATFREE", 0.5));
        register(new DoubleQualityStandard("SNF", 8.0));
        register(new DoubleQualityStandard("CADMIUM_CONT", 0.2));
        register(new DoubleQualityStandard("LEAD_CONT", 0.02));
        register(new DoubleQualityStandard("TIN_CONT", 40.0));
        register(new DoubleQualityStandard("MERCURY_CONT", 0.03));
        register(new DoubleQualityStandard("ARSENIC_CONT", 0.1));
        register(new DoubleQualityStandard("AFLATOXIN_CONT", 0.5));
        register(new DoubleQualityStandard("TPC_CONT", 10.0));
    }

    private DoubleQualityStandard(String name, double standardValue) {
        this.name = name;
        this.standardValue = standardValue;
    }

    private static void register(DoubleQualityStandard standard) {
        standards.put(standard.name, standard);
    }

    public static DoubleQualityStandard get(String name) {
        return standards.get(name);
    }

    public static Set<String> getAllParameterNames() {
        return Collections.unmodifiableSet(standards.keySet());
    }

    public String getName() {
        return name;
    }

    public double getStandardValue() {
        return standardValue;
    }
}
