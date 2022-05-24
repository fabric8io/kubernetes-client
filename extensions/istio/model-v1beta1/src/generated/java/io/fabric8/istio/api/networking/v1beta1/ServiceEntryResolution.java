
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceEntryResolution {

    NONE("NONE"),
    STATIC("STATIC"),
    DNS("DNS"),
    DNS_ROUND_ROBIN("DNS_ROUND_ROBIN");
    private final String value;
    private final static Map<String, ServiceEntryResolution> CONSTANTS = new HashMap<String, ServiceEntryResolution>();

    static {
        for (ServiceEntryResolution c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ServiceEntryResolution(String value) {
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
    public static ServiceEntryResolution fromValue(String value) {
        ServiceEntryResolution constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
