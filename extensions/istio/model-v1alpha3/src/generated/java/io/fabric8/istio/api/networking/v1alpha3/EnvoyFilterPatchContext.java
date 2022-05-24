
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnvoyFilterPatchContext {

    ANY("ANY"),
    SIDECAR_INBOUND("SIDECAR_INBOUND"),
    SIDECAR_OUTBOUND("SIDECAR_OUTBOUND"),
    GATEWAY("GATEWAY");
    private final String value;
    private final static Map<String, EnvoyFilterPatchContext> CONSTANTS = new HashMap<String, EnvoyFilterPatchContext>();

    static {
        for (EnvoyFilterPatchContext c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private EnvoyFilterPatchContext(String value) {
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
    public static EnvoyFilterPatchContext fromValue(String value) {
        EnvoyFilterPatchContext constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
