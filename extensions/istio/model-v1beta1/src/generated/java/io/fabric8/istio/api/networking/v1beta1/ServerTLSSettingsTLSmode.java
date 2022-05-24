
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServerTLSSettingsTLSmode {

    PASSTHROUGH("PASSTHROUGH"),
    SIMPLE("SIMPLE"),
    MUTUAL("MUTUAL"),
    AUTO_PASSTHROUGH("AUTO_PASSTHROUGH"),
    ISTIO_MUTUAL("ISTIO_MUTUAL");
    private final String value;
    private final static Map<String, ServerTLSSettingsTLSmode> CONSTANTS = new HashMap<String, ServerTLSSettingsTLSmode>();

    static {
        for (ServerTLSSettingsTLSmode c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ServerTLSSettingsTLSmode(String value) {
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
    public static ServerTLSSettingsTLSmode fromValue(String value) {
        ServerTLSSettingsTLSmode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
