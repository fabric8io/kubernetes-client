
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum LoadBalancerSettingsSimpleLB {

    UNSPECIFIED(0),
    LEAST_CONN(1),
    RANDOM(2),
    PASSTHROUGH(3),
    ROUND_ROBIN(4),
    LEAST_REQUEST(5);
    private final Integer value;
    private final static Map<Integer, LoadBalancerSettingsSimpleLB> CONSTANTS = new HashMap<Integer, LoadBalancerSettingsSimpleLB>();
    private final static Map<String, LoadBalancerSettingsSimpleLB> NAME_CONSTANTS = new HashMap<String, LoadBalancerSettingsSimpleLB>();

    static {
        for (LoadBalancerSettingsSimpleLB c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (LoadBalancerSettingsSimpleLB c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    LoadBalancerSettingsSimpleLB(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static LoadBalancerSettingsSimpleLB fromValue(Object value) {
        if (value instanceof String) {
            {
                LoadBalancerSettingsSimpleLB constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        LoadBalancerSettingsSimpleLB constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
