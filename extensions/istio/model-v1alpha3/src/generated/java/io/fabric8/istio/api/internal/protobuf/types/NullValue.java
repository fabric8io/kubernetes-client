
package io.fabric8.istio.api.internal.protobuf.types;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NullValue {

    NULL_VALUE("NULL_VALUE");
    private final String value;
    private final static Map<String, NullValue> CONSTANTS = new HashMap<String, NullValue>();

    static {
        for (NullValue c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private NullValue(String value) {
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
    public static NullValue fromValue(String value) {
        NullValue constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
