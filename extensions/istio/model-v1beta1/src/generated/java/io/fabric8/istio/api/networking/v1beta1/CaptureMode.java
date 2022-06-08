
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CaptureMode {

    DEFAULT("DEFAULT"),
    IPTABLES("IPTABLES"),
    NONE("NONE");
    private final String value;
    private final static Map<String, CaptureMode> CONSTANTS = new HashMap<String, CaptureMode>();

    static {
        for (CaptureMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private CaptureMode(String value) {
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
    public static CaptureMode fromValue(String value) {
        CaptureMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
