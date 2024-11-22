
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum MetricsOverridesTagOverrideOperation 
{
    REMOVE(1),
    UPSERT(0);
    private final int value;
    private MetricsOverridesTagOverrideOperation(int value) {
        this.value = value;
    }

    @JsonCreator
    public static MetricsOverridesTagOverrideOperation fromValue(Object value) {
        if (value instanceof String) {
            for (MetricsOverridesTagOverrideOperation e : MetricsOverridesTagOverrideOperation.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (MetricsOverridesTagOverrideOperation e : MetricsOverridesTagOverrideOperation.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
