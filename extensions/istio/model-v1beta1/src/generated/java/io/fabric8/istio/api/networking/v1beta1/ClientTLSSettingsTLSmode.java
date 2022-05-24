
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientTLSSettingsTLSmode {

    DISABLE("DISABLE"),
    SIMPLE("SIMPLE"),
    MUTUAL("MUTUAL"),
    ISTIO_MUTUAL("ISTIO_MUTUAL");
    private final String value;
    private final static Map<String, ClientTLSSettingsTLSmode> CONSTANTS = new HashMap<String, ClientTLSSettingsTLSmode>();

    static {
        for (ClientTLSSettingsTLSmode c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ClientTLSSettingsTLSmode(String value) {
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
    public static ClientTLSSettingsTLSmode fromValue(String value) {
        ClientTLSSettingsTLSmode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
