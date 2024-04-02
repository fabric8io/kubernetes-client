
package io.fabric8.istio.api.networking.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum FailStrategy {

    FAIL_CLOSE(0),
    FAIL_OPEN(1);
    private final Integer value;
    private final static Map<Integer, FailStrategy> CONSTANTS = new HashMap<Integer, FailStrategy>();
    private final static Map<String, FailStrategy> NAME_CONSTANTS = new HashMap<String, FailStrategy>();

    static {
        for (FailStrategy c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (FailStrategy c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    FailStrategy(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static FailStrategy fromValue(Object value) {
        if (value instanceof String) {
            {
                FailStrategy constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        FailStrategy constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
