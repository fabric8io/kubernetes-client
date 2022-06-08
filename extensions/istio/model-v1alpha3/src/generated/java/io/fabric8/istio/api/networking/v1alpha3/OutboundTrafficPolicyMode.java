
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OutboundTrafficPolicyMode {

    REGISTRY_ONLY("REGISTRY_ONLY"),
    ALLOW_ANY("ALLOW_ANY");
    private final String value;
    private final static Map<String, OutboundTrafficPolicyMode> CONSTANTS = new HashMap<String, OutboundTrafficPolicyMode>();

    static {
        for (OutboundTrafficPolicyMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private OutboundTrafficPolicyMode(String value) {
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
    public static OutboundTrafficPolicyMode fromValue(String value) {
        OutboundTrafficPolicyMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
