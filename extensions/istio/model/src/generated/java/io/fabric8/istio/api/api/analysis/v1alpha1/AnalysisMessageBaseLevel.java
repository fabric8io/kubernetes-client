
package io.fabric8.istio.api.api.analysis.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The values here are chosen so that more severe messages get sorted higher, as well as leaving space in between to add more later
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum AnalysisMessageBaseLevel 
{
    ERROR(3),
    INFO(12),
    UNKNOWN(0),
    WARNING(8);
    private final int value;
    private AnalysisMessageBaseLevel(int value) {
        this.value = value;
    }

    @JsonCreator
    public static AnalysisMessageBaseLevel fromValue(Object value) {
        if (value instanceof String) {
            for (AnalysisMessageBaseLevel e : AnalysisMessageBaseLevel.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (AnalysisMessageBaseLevel e : AnalysisMessageBaseLevel.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
