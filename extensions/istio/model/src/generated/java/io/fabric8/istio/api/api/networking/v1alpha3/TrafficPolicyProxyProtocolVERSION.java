
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum TrafficPolicyProxyProtocolVERSION 
{
    V1(0),
    V2(1);
    private final int value;
    private TrafficPolicyProxyProtocolVERSION(int value) {
        this.value = value;
    }

    @JsonCreator
    public static TrafficPolicyProxyProtocolVERSION fromValue(Object value) {
        if (value instanceof String) {
            for (TrafficPolicyProxyProtocolVERSION e : TrafficPolicyProxyProtocolVERSION.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (TrafficPolicyProxyProtocolVERSION e : TrafficPolicyProxyProtocolVERSION.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
