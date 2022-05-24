
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LoadBalancerSettingsSimpleLB {

    ROUND_ROBIN("ROUND_ROBIN"),
    LEAST_CONN("LEAST_CONN"),
    RANDOM("RANDOM"),
    PASSTHROUGH("PASSTHROUGH");
    private final String value;
    private final static Map<String, LoadBalancerSettingsSimpleLB> CONSTANTS = new HashMap<String, LoadBalancerSettingsSimpleLB>();

    static {
        for (LoadBalancerSettingsSimpleLB c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private LoadBalancerSettingsSimpleLB(String value) {
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
    public static LoadBalancerSettingsSimpleLB fromValue(String value) {
        LoadBalancerSettingsSimpleLB constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
