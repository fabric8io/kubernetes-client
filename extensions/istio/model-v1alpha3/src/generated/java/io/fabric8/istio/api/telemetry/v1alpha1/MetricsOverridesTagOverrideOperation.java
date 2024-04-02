
package io.fabric8.istio.api.telemetry.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum MetricsOverridesTagOverrideOperation {

    UPSERT(0),
    REMOVE(1);
    private final Integer value;
    private final static Map<Integer, MetricsOverridesTagOverrideOperation> CONSTANTS = new HashMap<Integer, MetricsOverridesTagOverrideOperation>();
    private final static Map<String, MetricsOverridesTagOverrideOperation> NAME_CONSTANTS = new HashMap<String, MetricsOverridesTagOverrideOperation>();

    static {
        for (MetricsOverridesTagOverrideOperation c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (MetricsOverridesTagOverrideOperation c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    MetricsOverridesTagOverrideOperation(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static MetricsOverridesTagOverrideOperation fromValue(Object value) {
        if (value instanceof String) {
            {
                MetricsOverridesTagOverrideOperation constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        MetricsOverridesTagOverrideOperation constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
