
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum OutboundTrafficPolicyMode {

    REGISTRY_ONLY(0),
    ALLOW_ANY(1);
    private final Integer value;
    private final static Map<Integer, OutboundTrafficPolicyMode> CONSTANTS = new HashMap<Integer, OutboundTrafficPolicyMode>();
    private final static Map<String, OutboundTrafficPolicyMode> NAME_CONSTANTS = new HashMap<String, OutboundTrafficPolicyMode>();

    static {
        for (OutboundTrafficPolicyMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (OutboundTrafficPolicyMode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    OutboundTrafficPolicyMode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static OutboundTrafficPolicyMode fromValue(Object value) {
        if (value instanceof String) {
            {
                OutboundTrafficPolicyMode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        OutboundTrafficPolicyMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
