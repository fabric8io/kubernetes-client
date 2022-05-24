
package io.fabric8.istio.api.security.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PeerAuthenticationMutualTLSMode {

    UNSET("UNSET"),
    DISABLE("DISABLE"),
    PERMISSIVE("PERMISSIVE"),
    STRICT("STRICT");
    private final String value;
    private final static Map<String, PeerAuthenticationMutualTLSMode> CONSTANTS = new HashMap<String, PeerAuthenticationMutualTLSMode>();

    static {
        for (PeerAuthenticationMutualTLSMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private PeerAuthenticationMutualTLSMode(String value) {
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
    public static PeerAuthenticationMutualTLSMode fromValue(String value) {
        PeerAuthenticationMutualTLSMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
