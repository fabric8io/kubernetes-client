
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnvoyFilterPatchOperation {

    INVALID("INVALID"),
    MERGE("MERGE"),
    ADD("ADD"),
    REMOVE("REMOVE"),
    INSERT_BEFORE("INSERT_BEFORE"),
    INSERT_AFTER("INSERT_AFTER"),
    INSERT_FIRST("INSERT_FIRST"),
    REPLACE("REPLACE");
    private final String value;
    private final static Map<String, EnvoyFilterPatchOperation> CONSTANTS = new HashMap<String, EnvoyFilterPatchOperation>();

    static {
        for (EnvoyFilterPatchOperation c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private EnvoyFilterPatchOperation(String value) {
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
    public static EnvoyFilterPatchOperation fromValue(String value) {
        EnvoyFilterPatchOperation constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
