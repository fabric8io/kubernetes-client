
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum TrafficPolicyProxyProtocolVERSION {

    V1(0),
    V2(1);
    private final Integer value;
    private final static Map<Integer, TrafficPolicyProxyProtocolVERSION> CONSTANTS = new HashMap<Integer, TrafficPolicyProxyProtocolVERSION>();
    private final static Map<String, TrafficPolicyProxyProtocolVERSION> NAME_CONSTANTS = new HashMap<String, TrafficPolicyProxyProtocolVERSION>();

    static {
        for (TrafficPolicyProxyProtocolVERSION c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (TrafficPolicyProxyProtocolVERSION c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    TrafficPolicyProxyProtocolVERSION(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static TrafficPolicyProxyProtocolVERSION fromValue(Object value) {
        if (value instanceof String) {
            {
                TrafficPolicyProxyProtocolVERSION constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        TrafficPolicyProxyProtocolVERSION constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
