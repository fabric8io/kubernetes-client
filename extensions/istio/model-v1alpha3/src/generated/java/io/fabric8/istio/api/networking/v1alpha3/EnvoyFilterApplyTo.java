
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnvoyFilterApplyTo {

    INVALID("INVALID"),
    LISTENER("LISTENER"),
    FILTER_CHAIN("FILTER_CHAIN"),
    NETWORK_FILTER("NETWORK_FILTER"),
    HTTP_FILTER("HTTP_FILTER"),
    ROUTE_CONFIGURATION("ROUTE_CONFIGURATION"),
    VIRTUAL_HOST("VIRTUAL_HOST"),
    HTTP_ROUTE("HTTP_ROUTE"),
    CLUSTER("CLUSTER"),
    EXTENSION_CONFIG("EXTENSION_CONFIG"),
    BOOTSTRAP("BOOTSTRAP");
    private final String value;
    private final static Map<String, EnvoyFilterApplyTo> CONSTANTS = new HashMap<String, EnvoyFilterApplyTo>();

    static {
        for (EnvoyFilterApplyTo c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private EnvoyFilterApplyTo(String value) {
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
    public static EnvoyFilterApplyTo fromValue(String value) {
        EnvoyFilterApplyTo constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
