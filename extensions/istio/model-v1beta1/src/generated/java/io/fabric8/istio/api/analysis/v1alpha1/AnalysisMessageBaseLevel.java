
package io.fabric8.istio.api.analysis.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AnalysisMessageBaseLevel {

    UNKNOWN("UNKNOWN");
    private final String value;
    private final static Map<String, AnalysisMessageBaseLevel> CONSTANTS = new HashMap<String, AnalysisMessageBaseLevel>();

    static {
        for (AnalysisMessageBaseLevel c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private AnalysisMessageBaseLevel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static AnalysisMessageBaseLevel fromValue(String value) {
        AnalysisMessageBaseLevel constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
