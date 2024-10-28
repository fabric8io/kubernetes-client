
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum WorkloadMode 
{
    CLIENT(1),
    CLIENT_AND_SERVER(0),
    SERVER(2);
    private final int value;
    private WorkloadMode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static WorkloadMode fromValue(Object value) {
        if (value instanceof String) {
            for (WorkloadMode e : WorkloadMode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (WorkloadMode e : WorkloadMode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
