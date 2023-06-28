
package io.fabric8.istio.api.internal.protobuf.types;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum NullValue {

    NULL_VALUE(0);
    private final Integer value;
    private final static Map<Integer, NullValue> CONSTANTS = new HashMap<Integer, NullValue>();
    private final static Map<String, NullValue> NAME_CONSTANTS = new HashMap<String, NullValue>();

    static {
        for (NullValue c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (NullValue c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    NullValue(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static NullValue fromValue(Object value) {
        if (value instanceof String) {
            {
                NullValue constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        NullValue constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
