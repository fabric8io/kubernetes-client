
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnvoyFilterPatchFilterClass {

    UNSPECIFIED("UNSPECIFIED"),
    AUTHN("AUTHN"),
    AUTHZ("AUTHZ"),
    STATS("STATS");
    private final String value;
    private final static Map<String, EnvoyFilterPatchFilterClass> CONSTANTS = new HashMap<String, EnvoyFilterPatchFilterClass>();

    static {
        for (EnvoyFilterPatchFilterClass c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private EnvoyFilterPatchFilterClass(String value) {
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
    public static EnvoyFilterPatchFilterClass fromValue(String value) {
        EnvoyFilterPatchFilterClass constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
