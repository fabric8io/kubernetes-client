
package io.fabric8.istio.api.type.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum WorkloadMode {

    UNDEFINED(0),
    CLIENT(1),
    SERVER(2),
    CLIENT_AND_SERVER(3);
    private final Integer value;
    private final static Map<Integer, WorkloadMode> CONSTANTS = new HashMap<Integer, WorkloadMode>();
    private final static Map<String, WorkloadMode> NAME_CONSTANTS = new HashMap<String, WorkloadMode>();

    static {
        for (WorkloadMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (WorkloadMode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    WorkloadMode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static WorkloadMode fromValue(Object value) {
        if (value instanceof String) {
            {
                WorkloadMode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        WorkloadMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
