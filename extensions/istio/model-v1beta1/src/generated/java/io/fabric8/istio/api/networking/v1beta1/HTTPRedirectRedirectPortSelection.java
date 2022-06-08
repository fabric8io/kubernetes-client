
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HTTPRedirectRedirectPortSelection {

    FROM_PROTOCOL_DEFAULT("FROM_PROTOCOL_DEFAULT"),
    FROM_REQUEST_PORT("FROM_REQUEST_PORT");
    private final String value;
    private final static Map<String, HTTPRedirectRedirectPortSelection> CONSTANTS = new HashMap<String, HTTPRedirectRedirectPortSelection>();

    static {
        for (HTTPRedirectRedirectPortSelection c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private HTTPRedirectRedirectPortSelection(String value) {
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
    public static HTTPRedirectRedirectPortSelection fromValue(String value) {
        HTTPRedirectRedirectPortSelection constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
