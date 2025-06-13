package Project.QualiCheck.Standard;

import java.util.*;

public class BooleanQualityStandard {
    private final String name;
    private final boolean standardValue;

    private static final HashMap<String, BooleanQualityStandard> standards = new HashMap<String, BooleanQualityStandard>();
    private static List<String> parameters;

    public static void initializeStandard(){
        register(new BooleanQualityStandard("SMELL", true));
        register(new BooleanQualityStandard("COLOR", true));
        register(new BooleanQualityStandard("TASTE", true));
    }

    private BooleanQualityStandard(String name, boolean standardValue) {
        this.name = name;
        this.standardValue = standardValue;
    }

    private static void register(BooleanQualityStandard standard) {
        standards.put(standard.name, standard);
    }

    public static BooleanQualityStandard get(String name) {
        return standards.get(name);
    }

    public static List<String> getAllParameterNames() {
    	parameters = new ArrayList<>(standards.keySet());
        return Collections.unmodifiableList(parameters);
    }

    public String getName() {
        return name;
    }

    public boolean getStandardValue() {
        return standardValue;
    }
}
