
package io.fabric8.istio.api.networking.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvValueSource {

    INLINE(0),
    HOST(1);
    private final Integer value;
    private final static Map<Integer, EnvValueSource> CONSTANTS = new HashMap<Integer, EnvValueSource>();
    private final static Map<String, EnvValueSource> NAME_CONSTANTS = new HashMap<String, EnvValueSource>();

    static {
        for (EnvValueSource c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvValueSource c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvValueSource(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvValueSource fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvValueSource constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvValueSource constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
