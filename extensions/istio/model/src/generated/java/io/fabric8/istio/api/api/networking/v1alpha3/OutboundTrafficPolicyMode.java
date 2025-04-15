
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum OutboundTrafficPolicyMode 
{
    ALLOW_ANY(1),
    REGISTRY_ONLY(0);
    private final int value;
    private OutboundTrafficPolicyMode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static OutboundTrafficPolicyMode fromValue(Object value) {
        if (value instanceof String) {
            for (OutboundTrafficPolicyMode e : OutboundTrafficPolicyMode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (OutboundTrafficPolicyMode e : OutboundTrafficPolicyMode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
