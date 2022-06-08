
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceEntryLocation {

    MESH_EXTERNAL("MESH_EXTERNAL"),
    MESH_INTERNAL("MESH_INTERNAL");
    private final String value;
    private final static Map<String, ServiceEntryLocation> CONSTANTS = new HashMap<String, ServiceEntryLocation>();

    static {
        for (ServiceEntryLocation c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ServiceEntryLocation(String value) {
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
    public static ServiceEntryLocation fromValue(String value) {
        ServiceEntryLocation constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
