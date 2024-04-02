
package io.fabric8.istio.api.networking.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum PullPolicy {

    UNSPECIFIED_POLICY(0),
    IfNotPresent(1),
    Always(2);
    private final Integer value;
    private final static Map<Integer, PullPolicy> CONSTANTS = new HashMap<Integer, PullPolicy>();
    private final static Map<String, PullPolicy> NAME_CONSTANTS = new HashMap<String, PullPolicy>();

    static {
        for (PullPolicy c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (PullPolicy c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    PullPolicy(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static PullPolicy fromValue(Object value) {
        if (value instanceof String) {
            {
                PullPolicy constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        PullPolicy constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
