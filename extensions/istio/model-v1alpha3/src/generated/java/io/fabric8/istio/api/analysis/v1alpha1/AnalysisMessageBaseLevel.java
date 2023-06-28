
package io.fabric8.istio.api.analysis.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum AnalysisMessageBaseLevel {

    UNKNOWN(0),
    ERROR(3),
    WARNING(8),
    INFO(12);
    private final Integer value;
    private final static Map<Integer, AnalysisMessageBaseLevel> CONSTANTS = new HashMap<Integer, AnalysisMessageBaseLevel>();
    private final static Map<String, AnalysisMessageBaseLevel> NAME_CONSTANTS = new HashMap<String, AnalysisMessageBaseLevel>();

    static {
        for (AnalysisMessageBaseLevel c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (AnalysisMessageBaseLevel c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    AnalysisMessageBaseLevel(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static AnalysisMessageBaseLevel fromValue(Object value) {
        if (value instanceof String) {
            {
                AnalysisMessageBaseLevel constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        AnalysisMessageBaseLevel constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
