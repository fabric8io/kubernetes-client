
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * ExecutionPhase specifies where in the filter chain a `TrafficExtension` is injected.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum TrafficExtensionExecutionPhase 
{
    AUTHN(1),
    AUTHZ(2),
    STATS(3),
    UNSPECIFIED(0);
    private final int value;
    private TrafficExtensionExecutionPhase(int value) {
        this.value = value;
    }

    @JsonCreator
    public static TrafficExtensionExecutionPhase fromValue(Object value) {
        if (value instanceof String) {
            for (TrafficExtensionExecutionPhase e : TrafficExtensionExecutionPhase.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (TrafficExtensionExecutionPhase e : TrafficExtensionExecutionPhase.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
